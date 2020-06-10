/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.student.filter;

import com.auth0.jwt.JWT;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import com.example.student.DTO.LoginDto;
import static com.example.student.constants.SecurityConstants.EXPIRATION_TIME;
import static com.example.student.constants.SecurityConstants.HEADER_STRING;
import static com.example.student.constants.SecurityConstants.SECRET;
import static com.example.student.constants.SecurityConstants.TOKEN_PREFIX;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author nilambar
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            LoginDto creds = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginDto.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getName(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = JWT.create()
                .withSubject(((User) authResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));
//        Cookie cookie = new Cookie("usercookie", "mycookie");
//        cookie.setSecure(true);
//        response.addCookie(cookie);
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
