package com.ilys.ToDoList.Controller;

import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Service.iUserService;
import com.ilys.ToDoList.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private iUserService userService;

    @Autowired
    private Util util;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user, @RequestParam(required = false) Long idRol){
        userService.saveUser(user);
        if (idRol != null){
            this.addRoleToUser(user.getId(), idRol);
        }
        this.addRoleToUser(user.getId(), 1L);
        return util.responseOBJ_OK(user);
    }

    @GetMapping(value = {"/findAll", "/findById/{id}" })
    public ResponseEntity<List<User>> getUser(@PathVariable(required = false) Long id){
        return util.responseOBJ_OK(userService.getUserDetails(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return util.response_OK("User deleted successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return util.responseOBJ_OK(userService.updateUser(user));
    }

    //API para ROL
    @PutMapping("/addRole/{idUser}/rol/{idRol}")
    public ResponseEntity<User> addRoleToUser(@PathVariable Long idUser, @PathVariable Long idRol){
        return util.responseOBJ_OK(userService.addRole(idUser, idRol));
    }

    @GetMapping("/getRoles/{idUser}")
    public ResponseEntity<Set<Rol>> getRolesByIdUser(@PathVariable Long idUser){
        return util.responseOBJ_OK(userService.getRolesByIdUser(idUser));
    }
}
