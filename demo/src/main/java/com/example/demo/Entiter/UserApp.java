package com.example.demo.Entiter;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class UserApp {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)

 private Long id ;
 @Column(unique=true)
 private  String username ;

 private String password;
 /*pour chaque utilsateur en peux charger ses roles */
 @ManyToMany(fetch=FetchType.EAGER)
 private Collection<RoleApp> roles=new ArrayList<>();

    public UserApp( String username, String password,Collection<RoleApp> roles) {

        this.username = username;
    this.password=password;
        this.roles = roles;
    }

    public UserApp() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<RoleApp> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleApp> roles) {
        this.roles = roles;
    }
//je ne retourne pas le mot de passe au format json  ***Dto
    @JsonIgnore
    public String getPassword() {
        return password;
    }
// je prend le mot de passe s'il vient paratir d'un format json
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }
}













