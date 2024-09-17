package com.ilys.ToDoList.Service;

import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;

import java.util.List;
import java.util.Set;

public interface iRolService {
    List<Rol> getRolDetailsById(Long id);
    Rol saveRol(Rol rol);
    void deleteById(Long id);
    Rol addUser(Long idUser, Long idRol);
    Set<User> getUserByIdRol(Long idRol);
}
