package com.baridonfrancisco.forohub.security;

/*Este filtro se registra en la SegurirtyFilterChain
* como bean gracias a DelegationFilterProxy*/


import com.baridonfrancisco.forohub.domain.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;


    @Autowired
    UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Aunthentication Filter....");
        String token=request.getHeader("Authorization");
        System.out.println("url "+request.getRequestURI());
        boolean registerUser= request.getRequestURI().equals("/users")&&
                request.getMethod().equals("POST");

        System.out.println(registerUser);
        if(token!=null && !registerUser){
            token=token.replace("Bearer ","");

           String username=tokenService.getSubject(token);
            if(username!=null){
                UserDetails userDetails=userRepository.findByUserName(username);
                Authentication auth=new UsernamePasswordAuthenticationToken(userDetails,null,
                        userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);

            }

        }
        filterChain.doFilter(request,response);
    }
}
