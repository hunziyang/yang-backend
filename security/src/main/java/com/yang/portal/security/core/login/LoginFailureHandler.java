package com.yang.portal.security.core.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.portal.core.result.Result;
import com.yang.portal.core.utils.ResponseUtil;
import com.yang.portal.security.result.SecurityResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        if (exception instanceof UsernameNotFoundException) {
            ResponseUtil.setResponse(response, objectMapper.writeValueAsString(Result.error(SecurityResultCode.USER_NOT_EXISTS)));
            return;
        }
        if (exception instanceof LockedException) {
            ResponseUtil.setResponse(response, objectMapper.writeValueAsString(Result.error(SecurityResultCode.USER_LOCKED)));
            return;
        }
        if (exception instanceof BadCredentialsException) {
            ResponseUtil.setResponse(response, objectMapper.writeValueAsString(Result.error(SecurityResultCode.USER_BAD_CREDENTIALS)));
            return;
        }
        ResponseUtil.setResponse(response, objectMapper.writeValueAsString(Result.error(SecurityResultCode.AUTHENTICATION_ERROR)));
    }
}
