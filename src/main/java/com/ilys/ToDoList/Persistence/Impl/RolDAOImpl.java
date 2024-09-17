package com.ilys.ToDoList.Persistence.Impl;

import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Persistence.iRolDAO;
import com.ilys.ToDoList.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class RolDAOImpl implements iRolDAO {
    @Autowired
    private RolRepository rolRepository;
    @Override
    public List<Rol> getRolDetailsById(Long id) {
        if (null != id){
            return rolRepository.findAllById(id);
        } else {
            return rolRepository.findAll();
        }
    }

    @Override
    public Rol saveRol(Rol rol) {
        rolRepository.save(rol);
        return rol;
    }

    @Override
    public void deleteById(Long id) {
        Rol rol = rolRepository.findById(id).get();
        rol.setActive(0);
        rolRepository.save(rol);
    }

    @Override
    public Set<User> getUserByIdRol(Long idRol) {
        Optional<Rol> rol = rolRepository.findById(idRol);
        return rol.map(Rol::getUsers).orElse(null);
    }
}
