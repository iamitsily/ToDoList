package com.ilys.ToDoList.Repository;

import com.ilys.ToDoList.Model.ToDo;
import com.ilys.ToDoList.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllById(Long id);
    List<ToDo> findAllByDate(Date date);
    List<ToDo> findAllByUser(User user);
}
