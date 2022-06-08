package com.yang.portal.security.core;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserPrincipal {

    private Long userId;
    private String nickName;
    private String phone;

}
