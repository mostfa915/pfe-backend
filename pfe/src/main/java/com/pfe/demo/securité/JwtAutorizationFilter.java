package com.pfe.demo.securité;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
@CrossOrigin("*")
public class JwtAutorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal
            (HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {



        String Jwt=request.getHeader(SecuriteConstraintes.HEADER_STRING);
  System.out.println("vottre jwt"+Jwt);
    if(Jwt==null || ! Jwt.startsWith(SecuriteConstraintes.TOKEN_PREFIX)){
        filterChain.doFilter(request,response);
        return;
    }
        Claims claims= Jwts.parser()
                .setSigningKey(SecuriteConstraintes.SECRET)
                .parseClaimsJws(Jwt.replace(SecuriteConstraintes.TOKEN_PREFIX,""))
                .getBody();
    String username=claims.getSubject();
        ArrayList<Map<String,String>>roles=(ArrayList<Map<String,String>>)claims.get("roles");
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        roles.forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.get("authority")));
        });
        UsernamePasswordAuthenticationToken authenticatedUser= new UsernamePasswordAuthenticationToken(username,null,authorities);
       authenticatedUser.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        filterChain.doFilter(request,response);
    }


}
