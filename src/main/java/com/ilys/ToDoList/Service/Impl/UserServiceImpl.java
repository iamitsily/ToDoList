package com.ilys.ToDoList.Service.Impl;

import com.ilys.ToDoList.Controller.DTO.LoginDTO;
import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Persistence.iUserDAO;
import com.ilys.ToDoList.Service.iUserService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements iUserService {
    @Autowired
    private iUserDAO userDAO;
    @Override
    public LoginDTO getUserByCredentials(User user) {
        if (userDAO.getUserByCredentials(user) == null){
            return null;
        }
        return userDAO.getUserByCredentials(user);
    }

    @Override
    public List<User> getUserDetails(Long id) {
        return userDAO.getUserDetails(id);
    }

    @Override
    public User saveUser(User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024,1,user.getPassword());
        user.setPassword(hash);
        userDAO.saveUser(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User addRole(Long idUser, Long idRol) {
        return userDAO.addRole(idUser, idRol);
    }

    @Override
    public Set<Rol> getRolesByIdUser(Long idUser) {
        return userDAO.getRolesByIdUser(idUser);
    }
}
