package com.example.todo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="todoitems")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="itemId")
    private Long itemId;

    @Column(name="listId")
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID listId;

    @Column(name="taskName")
    private String taskName;

    @Column(name="isDone")
    private Boolean isDone = false;

    @Column(name="createdAt")
    private Date createdAt = new Date();
}
