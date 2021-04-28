package com.formation.demo.entites;

import org.apache.tomcat.jni.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends Users {


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
