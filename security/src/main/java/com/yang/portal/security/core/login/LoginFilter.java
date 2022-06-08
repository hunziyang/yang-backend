package com.yang.portal.security.core.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.portal.core.jackson.JacksonConfig;
import com.yang.portal.security.SecurityConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

    public LoginFilter() {
        super(new AntPathRequestMatcher(SecurityConstant.Login.LOGIN_URL, SecurityConstant.Login.LOGIN_HTTP_METHOD));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        ObjectMapper objectMapper = new JacksonConfig().objectMapper();
        Map<String, String> map = objectMapper.readValue(request.getInputStream(), Map.class);
        String username = map.get(SecurityConstant.Login.USERNAME);
        String password = map.get(SecurityConstant.Login.PASSWORD);
        LoginToken loginToken = LoginToken.builder()
                .username(username)
                .password(password)
                .isAuthenticated(false)
                .build();
        return super.getAuthenticationManager().authenticate(loginToken);
    }
}
