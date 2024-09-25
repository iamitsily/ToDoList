package com.ilys.ToDoList.Persistence;

import com.ilys.ToDoList.Controller.DTO.LoginDTO;
import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;

import java.util.List;
import java.util.Set;

public interface iUserDAO {
    //Auth
    LoginDTO getUserByCredentials(User user);
    //Rol
    List<User> getUserDetails(Long id);
    User getUserByEmail(String email);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    //Rol
    User addRole(Long idUser, Long idRol);
    Set<Rol> getRolesByIdUser(Long idUser);



}
