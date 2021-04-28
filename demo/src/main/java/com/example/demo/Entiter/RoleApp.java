package com.example.demo.Entiter;

import javax.persistence.*;

@Entity
@Table(name = "Rolesss")

public class RoleApp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id ;
    private String roleName ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleApp() {

    }

    public RoleApp(String roleName) {
        this.roleName = roleName;
    }
}
