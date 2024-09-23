package com.ilys.ToDoList.Controller.DTO;

import com.ilys.ToDoList.Model.ToDo;
import lombok.Data;

import java.util.Date;

@Data
public class ToDoDTO {
    private Long id;
    private Date date;
    private String title;
    private String description;
    private Integer state;
    private Integer active;
    private UserDTO user;

    public ToDoDTO(Long id, Date date, String title, String description, Integer state, Integer active, UserDTO user) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.state = state;
        this.active = active;
        this.user = user;
    }
    public static ToDoDTO fromFullEntity(ToDo toDo) {
        return new ToDoDTO(
                toDo.getId(),
                toDo.getDate(),
                toDo.getTitle(),
                toDo.getDescription(),
                toDo.getState(),
                toDo.getActiveTodo(),
                new UserDTO(toDo.getUser())
        );
    }
    public static ToDoDTO fromEntityWithoutRol(ToDo toDo){
        return new ToDoDTO(
                toDo.getId(),
                toDo.getDate(),
                toDo.getTitle(),
                toDo.getDescription(),
                toDo.getState(),
                toDo.getActiveTodo(),
                new UserDTO(
                        toDo.getUser().getId(),
                        toDo.getUser().getEmail(),
                        toDo.getUser().getPassword(),
                        toDo.getUser().getName(),
                        toDo.getUser().getActive()
                )
        );
    }
}
