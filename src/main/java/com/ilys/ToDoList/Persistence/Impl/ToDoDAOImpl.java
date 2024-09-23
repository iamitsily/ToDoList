package com.ilys.ToDoList.Persistence.Impl;

import com.ilys.ToDoList.Model.ToDo;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Persistence.iToDoDAO;
import com.ilys.ToDoList.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class ToDoDAOImpl implements iToDoDAO {
    @Autowired
    private ToDoRepository toDoRepository;
    @Override
    public ToDo saveToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public List<ToDo> getToDosByIdUser(Long idUser) {
        if (null != idUser){
            return toDoRepository.findAllByIdAndActiveTodo(idUser,1);
        } else {
            return toDoRepository.findAll();
        }
    }

    @Override
    public void deleteToDoById(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElse(null);
        if (toDo == null){
            return;
        }
        toDo.setActiveTodo(0);
        toDoRepository.save(toDo);
    }

    @Override
    public List<ToDo> getToDosByDate(Date date) {
        return toDoRepository.findAllByDate(date);
    }

    @Override
    public List<ToDo> getToDosByUser(User user) {
        return toDoRepository.findAllByUserAndActiveTodo(user, 1);
    }
}
