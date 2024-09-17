package com.ilys.ToDoList.Controller;

import com.ilys.ToDoList.Controller.DTO.ToDoDTO;
import com.ilys.ToDoList.Model.ToDo;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Service.iToDoService;
import com.ilys.ToDoList.Service.iUserService;
import com.ilys.ToDoList.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    @Autowired
    private iToDoService toDoService;
    @Autowired
    private iUserService userService;
    @Autowired
    private Util util;

    @PostMapping("/register")
    public ResponseEntity<ToDo> registerToDo(@RequestBody ToDo toDo){
        toDoService.saveToDo(toDo);
        return util.responseOBJ_OK(toDo);
    }
    @GetMapping(value = {"/findAll", "/findById/{id}" })
    public ResponseEntity<?> getToDo(@PathVariable(required = false) Long id){
        List<ToDo> toDos = toDoService.getToDosByIdUser(id);
        List< ToDoDTO> dtos = toDos.stream().map(ToDoDTO::fromEntityWithoutRol).collect(Collectors.toList());
        return util.responseOBJ_OK(dtos);
    }
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDoById(id);
        return util.response_OK("ToDo deleted successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo){
        return util.responseOBJ_OK(toDoService.saveToDo(toDo));
    }
    @GetMapping("/findByDate/{date}")
    public ResponseEntity<?> getToDosByDate(@PathVariable Date date){
        List<ToDo> toDos = toDoService.getToDosByDate(date);
        List<ToDoDTO> dtos = toDos.stream()
                .map(ToDoDTO::fromEntityWithoutRol)
                .collect(Collectors.toList());
        return util.responseOBJ_OK(dtos);
    }
    @GetMapping("/findByUser/{idUser}")
    public ResponseEntity<?> getToDosByUser(@PathVariable Long idUser){
        User user = userService.getUserDetails(idUser).get(0);
        List<ToDo> toDos = toDoService.getToDosByUser(user);
        List<ToDoDTO> dtos = toDos.stream()
                .map(ToDoDTO::fromEntityWithoutRol)
                .collect(Collectors.toList());
        return util.responseOBJ_OK(dtos);
    }
}
