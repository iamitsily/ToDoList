package com.ilys.ToDoList.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ROLES")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "active", length = 1,nullable = false)
    private int active;

    @JsonIgnore
    @ManyToMany(mappedBy = "user_roles")
    private Set<User> users = new HashSet<>();
}
