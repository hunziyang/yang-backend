package com.yang.portal.security;

public interface SecurityConstant {

    int BASE_INDEX = 0;

    interface Salt {
        int BASE_CYCLE = 8;
        String MD5_PREFIX = "$YANG$";
    }

    interface Login {
        String LOGIN_URL = "/login";
        String LOGIN_HTTP_METHOD = "POST";
        String USERNAME = "username";
        String PASSWORD = "password";
    }

    interface Jwt {
        String SECRET = "SECRET_YANG";
        String AUTH_HEADER = "Authorization";
        long EXPIRE_TIME = 8 * 60 * 60 * 1000;
        long TIME_OUT = 2L;
    }

    interface Config {
        String REGISTER_URL = "/user/register";
    }
}
