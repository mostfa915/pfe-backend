package com.formation.demo.entites;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Client extends Users  {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
