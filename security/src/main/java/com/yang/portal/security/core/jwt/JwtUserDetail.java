package com.yang.portal.security.core.jwt;


import com.yang.portal.security.core.UserPrincipal;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.List;

@Accessors(chain = true)
@Data
public class JwtUserDetail implements Serializable {

    private UserPrincipal userPrincipal;
    private List<SimpleGrantedAuthority> authorities;
}
