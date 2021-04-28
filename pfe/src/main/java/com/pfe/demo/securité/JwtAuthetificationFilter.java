package com.pfe.demo.securité;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfe.demo.entiter.Utilisateur;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JwtAuthetificationFilter extends UsernamePasswordAuthenticationFilter {
 private AuthenticationManager authenticationManager;

    public JwtAuthetificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println( response.getHeader("Access-Control-Allow-Origin"));

      Utilisateur utilisateur=null;
    //  String Nom=request.getParameter("username");
      //  String mdp=request.getParameter("password");
        try {

               utilisateur = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);

        }catch (Exception e){
throw new RuntimeException(e) ;       }
       System.out.println("********");
        System.out.println(utilisateur.getUsername());
        System.out.println(utilisateur.getPassword());
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(utilisateur.getUsername(),utilisateur.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User springUser =(User) authResult.getPrincipal();
      String jwt= Jwts.builder()
              .setSubject(springUser.getUsername())
              .setExpiration(new Date(System.currentTimeMillis()+SecuriteConstraintes.EXPIRATION_TIME))
              .signWith(SignatureAlgorithm.HS256,SecuriteConstraintes.SECRET)
              .claim("roles",springUser.getAuthorities())
              .compact();
System.out.println("9**");
System.out.println(jwt);
              response.addHeader(SecuriteConstraintes.HEADER_STRING,SecuriteConstraintes.TOKEN_PREFIX+jwt);
        System.out.println(SecuriteConstraintes.TOKEN_PREFIX+jwt);


    }
}
