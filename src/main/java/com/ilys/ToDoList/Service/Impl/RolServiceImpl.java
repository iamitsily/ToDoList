package com.ilys.ToDoList.Service.Impl;

import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Persistence.iRolDAO;
import com.ilys.ToDoList.Persistence.iUserDAO;
import com.ilys.ToDoList.Service.iRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RolServiceImpl implements iRolService {
    @Autowired
    private iRolDAO rolDAO;
    @Autowired
    private iUserDAO userDAO;

    @Override
    public List<Rol> getRolDetailsById(Long id) {
        return rolDAO.getRolDetailsById(id);
    }

    @Override
    public Rol saveRol(Rol rol) {
        rolDAO.saveRol(rol);
        return rol;
    }

    @Override
    public void deleteById(Long id) {
        rolDAO.deleteById(id);
    }

    @Override
    public Rol addUser(Long idUser, Long idRol) {
        Set<User> userSet = null;
        Rol rol = rolDAO.getRolDetailsById(idRol).get(0);
        User user = userDAO.getUserDetails(idUser).get(0);
        userSet.add(user);
        rol.setUsers(userSet);
        return rolDAO.saveRol(rol);
    }

    @Override
    public Set<User> getUserByIdRol(Long idRol) {
        return rolDAO.getUserByIdRol(idRol);
    }
}
