package com.vehicle.vehicle.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired private UserDetailsService userDetailsService;
    @Autowired private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestAuthToken = request.getHeader(this.tokenHeader);
        String userName = null;
        String jwtToken = null;

        // JWT tokens is in the "Bearer token" form therefor Remove Bearer word
        if(requestAuthToken != null && requestAuthToken.startsWith("Bearer")){
            jwtToken = requestAuthToken.substring(7);
        }
        try {
            userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
        }catch (IllegalArgumentException e){
            System.out.println("Jwt token could not be found");
        }catch (ExpiredJwtException e){
            System.out.println("Jwt token is expired");
        }

        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
            boolean isValid = jwtTokenUtil.validateToken(jwtToken, userDetails);
            if(isValid){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
