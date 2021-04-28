package com.example.demo.service;

import com.example.demo.Entiter.UserApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserdetailServiceImplimentation implements UserDetailsService {
    @Autowired
    private CompteServices compteServices ;
    @Override
  /* cette methode qui va chercher le user par user name */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp user=compteServices.FindUserByUsername(username);
        if(user==null)throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(r->{
           /*recuperer les roles chaqun sous frome d'un SimpleGrantedAuthority dans authorities */
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
