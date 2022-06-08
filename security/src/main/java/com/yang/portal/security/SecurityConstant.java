package com.yang.portal.security;

public interface SecurityConstant {

    interface Salt {
        int BASE_CYCLE = 8;
        String MD5_PREFIX = "$YANG$";
    }

    interface PathPrefix{
        String ANONYMOUS_CONTROLLER = "/anonymous";
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

    interface SecuritySpringFox{
        String SECURITY_GROUP_NAME = "Security API";
        String MODULE_GROUP_NAME = "Module API";
        String SECURITY_BASE_PACKAGE = "com.yang.portal.security";
        String APIKEY_NAME = "Authorization";
        String APIKEY_KEY_NAME = "Authorization";
        String AUTHORIZATION_SCOPE = "global";
        String REGISTER_URL = "/user/register";
        String ANONYMOUS_URL = "/anonymous";
    }
}
