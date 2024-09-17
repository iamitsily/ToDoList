package com.ilys.ToDoList.Persistence;

import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;

import java.util.List;
import java.util.Set;

public interface iRolDAO {
    List<Rol> getRolDetailsById(Long id);
    Rol saveRol(Rol rol);
    void deleteById(Long id);
    Set<User> getUserByIdRol(Long idRol);
}
