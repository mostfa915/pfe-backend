package com.pfe.demo.Services;

import com.pfe.demo.entiter.Admin;
import com.pfe.demo.entiter.Utilisateur;
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
        Utilisateur utilisateur=compteServices.FindUserByUsername(username);
        if(utilisateur==null)throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        utilisateur.getRoles().forEach(r->{
            /*recuperer les roles chaqun sous frome d'un SimpleGrantedAuthority dans authorities */
            authorities.add(new SimpleGrantedAuthority(r.getRoleNom()));
        });
        return new User(utilisateur.getUsername(),utilisateur.getPassword(),authorities);
    }
}
