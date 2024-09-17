package com.ilys.ToDoList.Service.Impl;

import com.ilys.ToDoList.Model.ToDo;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Persistence.iToDoDAO;
import com.ilys.ToDoList.Service.iToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ToDoServiceImpl implements iToDoService {
    @Autowired
    private iToDoDAO toDoService;
    @Override
    public ToDo saveToDo(ToDo toDo) {
        return toDoService.saveToDo(toDo);
    }

    @Override
    public List<ToDo> getToDosByIdUser(Long idUser) {
        return toDoService.getToDosByIdUser(idUser);
    }

    @Override
    public void deleteToDoById(Long id) {
        toDoService.deleteToDoById(id);
    }

    @Override
    public List<ToDo> getToDosByDate(Date date) {
        return toDoService.getToDosByDate(date);
    }

    @Override
    public List<ToDo> getToDosByUser(User idUser) {
        return toDoService.getToDosByUser(idUser);
    }
}
