package com.example.demo.Entiter;



import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id ;
private String TaskName ;

    public Task(long id, String taskName) {
        this.id = id;
        TaskName = taskName;
    }
    public Task( String taskName) {

        TaskName = taskName;
    }
    public Task( ) {


    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }
}
