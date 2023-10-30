package com.taita.webapp.taskmanagement.config;

import com.taita.webapp.taskmanagement.dto.RequestMetaDTO;
import com.taita.webapp.taskmanagement.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    JwtUtil jwtUtil;

    RequestMetaDTO requestMetaDTO;

    public JwtInterceptor(RequestMetaDTO requestMetaDTO){
        this.requestMetaDTO = requestMetaDTO;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("authorization");
        if (!(request.getRequestURI().contains("auth"))){
            Claims claims = jwtUtil.verifyAccessToken(authorization);

            requestMetaDTO.setId(Long.valueOf(claims.getIssuer()));
            requestMetaDTO.setFirstName(claims.get("firstName").toString());
            requestMetaDTO.setLastName(claims.get("lastName").toString());
            requestMetaDTO.setEmail(claims.get("email").toString());
        }
        return super.preHandle(request, response, handler);
    }
}
