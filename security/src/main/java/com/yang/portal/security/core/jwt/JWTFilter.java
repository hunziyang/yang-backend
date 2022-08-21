package com.yang.portal.security.core.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.portal.core.result.Result;
import com.yang.portal.core.utils.ResponseUtil;
import com.yang.portal.security.SecurityConstant;
import com.yang.portal.security.result.SecurityResultCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    @Qualifier("securityRedisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        RequestMatcher requestMatcher = new RequestHeaderRequestMatcher(SecurityConstant.Jwt.AUTH_HEADER);
        if (!requestMatcher.matches(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwt = request.getHeader(SecurityConstant.Jwt.AUTH_HEADER);
        if (StringUtils.isBlank(jwt) || !redisTemplate.hasKey(jwt)) {
            ResponseUtil.setResponse(response, objectMapper.writeValueAsString(Result.error(SecurityResultCode.AUTHENTICATION_ERROR)));
            return;
        }
        JwtUserDetail jwtUserDetail = (JwtUserDetail) redisTemplate.opsForValue().get(jwt);
        JWTToken jwtToken = JWTToken.builder()
                .jwt(jwt)
                .isAuthenticated(true)
                .userPrincipal(jwtUserDetail.getUserPrincipal())
                .simpleGrantedAuthorityList(jwtUserDetail.getAuthorities())
                .build();
        SecurityContextHolder.getContext().setAuthentication(jwtToken);
        filterChain.doFilter(request, response);
    }
}
