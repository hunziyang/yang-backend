package com.yang.portal.security.core.login;

import com.yang.portal.core.utils.SpringUtil;
import com.yang.portal.security.SecurityConstant;
import com.yang.portal.security.core.UserPrincipal;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class LoginProvider implements AuthenticationProvider {
    private final UserDetailServiceImpl userDetailService = SpringUtil.getBean("userDetailServiceImpl", UserDetailServiceImpl.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LoginToken loginToken = (LoginToken) authentication;
        String username = loginToken.getUsername();
        LoginUserDetail userDetails = (LoginUserDetail) userDetailService.loadUserByUsername(username);
        if (userDetails.isAccountNonLocked()) {
            throw new LockedException("user locked");
        }
        String password = Md5Crypt.md5Crypt(
                loginToken.getPassword().getBytes(StandardCharsets.UTF_8),
                String.format("%s%s", SecurityConstant.Salt.MD5_PREFIX, userDetails.getSalt()), SecurityConstant.Salt.MD5_PREFIX);
        if (!userDetails.getPassword().equals(password)) {
            throw new BadCredentialsException("authentication error");
        }
        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setNickName(userDetails.getNickName())
                .setPhone(userDetails.getPhone())
                .setUserId(userDetails.getUserId());
        loginToken.setUserPrincipal(userPrincipal);
        loginToken.setAuthenticated(true);
        loginToken.setAuthorities((List<SimpleGrantedAuthority>) userDetails.getAuthorities());
        loginToken.setPassword("");
        return loginToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(LoginToken.class);
    }
}
