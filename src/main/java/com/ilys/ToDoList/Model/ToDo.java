package com.ilys.ToDoList.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", length = 20, nullable = false)
    private Date date;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "state", length = 1, nullable = false)
    private Integer state;

    @Column(name = "activeTodo", length = 1, nullable = false)
    private Integer activeTodo;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
