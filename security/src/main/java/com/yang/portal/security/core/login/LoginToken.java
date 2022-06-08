package com.yang.portal.security.core.login;

import com.yang.portal.security.core.UserPrincipal;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@Builder
public class LoginToken implements Authentication {

    private String username;
    private String password;
    private UserPrincipal userPrincipal;
    private Boolean isAuthenticated;
    private List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    /**
     * 细节信息, 比如, 对于web应用, 返回类型通常是 WebAuthenticationDetails 接口类型, 包含 IP 和 sessionId.
     *
     * @return
     */
    @Override
    public Object getDetails() {
        return null;
    }

    /**
     * 获取用户身份信息
     *
     * @return
     */
    @Override
    public Object getPrincipal() {
        return userPrincipal;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return username;
    }
}
