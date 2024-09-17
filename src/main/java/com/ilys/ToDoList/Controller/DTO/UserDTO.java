package com.ilys.ToDoList.Controller.DTO;

import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Integer active;
    private Set<Rol> user_roles;

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.active = user.getActive();
        this.user_roles = user.getUser_roles();
    }

    public UserDTO(Long id, String email, String password, String name, Integer active) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.active = active;
    }
}
