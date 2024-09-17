package com.ilys.ToDoList.Repository;

import com.ilys.ToDoList.Model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    List<Rol> findAllById(Long id);
}
