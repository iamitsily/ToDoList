package com.ilys.ToDoList.Persistence.Impl;

import com.ilys.ToDoList.Controller.DTO.LoginDTO;
import com.ilys.ToDoList.Controller.DTO.UserDTO;
import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Persistence.iUserDAO;
import com.ilys.ToDoList.Repository.RolRepository;
import com.ilys.ToDoList.Repository.UserRepository;
import com.ilys.ToDoList.Util.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UserDAOImpl implements iUserDAO {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private JWTUtil jwtUtil;
    @Override
    public LoginDTO getUserByCredentials(User user) {
        User user1= userRepository.findUserByEmail(user.getEmail());
        if (user1 == null){
            return null;
        }
        String passwordHashed = user1.getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(passwordHashed, user.getPassword())){
            User user2 = userRepository.findAllById(user1.getId()).get(0);
            System.out.println(user2);
            return new LoginDTO(jwtUtil.create(String.valueOf(user1.getId()), user1.getEmail()), new UserDTO(user2));
        }
        return null;
    }

    @Override
    public List<User> getUserDetails(Long id) {
        if (null != id){
            return userRepository.findAllById(id);
        } else {
            return userRepository.findAll();
        }
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            return;
        }
        user.setActive(0);
        userRepository.save(user);
    }

    @Override
    public User addRole(Long idUser, Long idRol) {
        Set<Rol> rolSet = null;
        User user = userRepository.findById(idUser).get();
        Rol rol = rolRepository.findById(idRol).get();
        rolSet = user.getUser_roles();
        rolSet.add(rol);
        user.setUser_roles(rolSet);
        return userRepository.save(user);
    }

    @Override
    public Set<Rol> getRolesByIdUser(Long idUser) {
        User user = userRepository.findUserWithRoles(idUser);
        return user.getUser_roles();
    }
}
