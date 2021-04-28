package com.pfe.demo.entiter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id ;

    private String user1;
    private String user2;
    @OneToMany(mappedBy = "idDiscussion",fetch = FetchType.LAZY)
    private Collection<Message> Messages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public Collection<Message> getMessages() {
        return Messages;
    }

    public void setMessages(Collection<Message> messages) {
        Messages = messages;
    }

    public Discussion() {
    }

    public Discussion(String user1, String user2, Collection<Message> messages) {
        this.user1 = user1;
        this.user2 = user2;
        Messages = messages;
    }
}
