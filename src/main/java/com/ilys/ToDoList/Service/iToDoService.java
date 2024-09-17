package com.ilys.ToDoList.Service;

import com.ilys.ToDoList.Model.ToDo;
import com.ilys.ToDoList.Model.User;

import java.sql.Date;
import java.util.List;

public interface iToDoService {
    ToDo saveToDo(ToDo toDo);
    List<ToDo> getToDosByIdUser(Long idUser);
    void deleteToDoById(Long id);

    //---
    List<ToDo> getToDosByDate(Date date);
    List<ToDo> getToDosByUser(User idUser);
}
