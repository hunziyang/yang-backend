package com.yang.portal.security.core.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.portal.core.utils.ResponseUtil;
import com.yang.portal.security.SecurityConstant;
import com.yang.portal.security.core.jwt.JwtUserDetail;
import com.yang.portal.security.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    @Qualifier("securityRedisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        LoginToken loginToken = (LoginToken) authentication;
        String jwt = JwtUtil.sign(loginToken.getUsername());
        List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) loginToken.getAuthorities();
        JwtUserDetail jwtUserDetail = new JwtUserDetail();
        jwtUserDetail.setUserPrincipal(loginToken.getUserPrincipal())
                .setAuthorities(authorities);
        redisTemplate.opsForValue().set(jwt, jwtUserDetail);
        redisTemplate.expire(jwt, SecurityConstant.Jwt.TIME_OUT, TimeUnit.HOURS);
        response.setHeader(SecurityConstant.Jwt.AUTH_HEADER, jwt);
        ResponseUtil.setResponse(response, objectMapper.writeValueAsString(authorities));
    }
}
