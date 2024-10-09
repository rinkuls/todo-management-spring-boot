package com.todo.springboot.todomanagementspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "todos")
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;

    @Size(min = 10, message = "Enter at least 10 Characters...")
    private String description;

    private Date targetDate;

    public Todo() {
        super();
    }

    public Todo(String user, String desc, Date targetDate, boolean isDone) {
        super();
        this.userName = user;
        this.description = desc;
        this.targetDate = targetDate;
    }


}