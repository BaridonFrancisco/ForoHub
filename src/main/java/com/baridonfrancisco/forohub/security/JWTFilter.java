package com.baridonfrancisco.forohub.security;

/*Este filtro se registra en la SegurirtyFilterChain
* como bean gracias a DelegationFilterProxy*/


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JWTFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        var res=new BCryptPasswordEncoder().encode("hola");
        System.out.println(res);
        filterChain.doFilter(request,response);
    }
}
