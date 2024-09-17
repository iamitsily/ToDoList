package com.ilys.ToDoList.Repository;

import com.ilys.ToDoList.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllById(Long id);
    @Query("SELECT u FROM User u JOIN FETCH u.user_roles WHERE u.id = :idUser")
    User findUserWithRoles(@Param("idUser") Long idUser);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);
}
