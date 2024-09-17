package com.ilys.ToDoList.Controller;

import com.ilys.ToDoList.Model.Rol;
import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Service.iRolService;
import com.ilys.ToDoList.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    @Autowired
    private iRolService rolService;
    @Autowired
    private Util util;

    @PostMapping("/register")
    public Rol registerRol(@RequestBody Rol rol){
        rolService.saveRol(rol);
        return rol;
    }

    @GetMapping(value = {"/findAll", "/findById/{id}" })
    public ResponseEntity<List<Rol>> getRol(@PathVariable(required = false) Long id){
        return util.responseOBJ_OK(rolService.getRolDetailsById(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Long id){
        rolService.deleteById(id);
        return util.response_OK("Rol deleted successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol rol){
        return util.responseOBJ_OK(rolService.saveRol(rol));
    }

    // API para USER

    @PutMapping("/addUser/{idRol}/user/{idUser}")
    public ResponseEntity<Rol> addUserToRol(@PathVariable Long idRol, @PathVariable Long idUser){
        return util.responseOBJ_OK(rolService.addUser(idRol, idUser));
    }

    @GetMapping("/getUsers/{idRol}")
    public ResponseEntity<Set<User>> getUsersByIdRol(@PathVariable Long idRol){
        Set<User> users = rolService.getUserByIdRol(idRol);
        if (users == null || users.isEmpty()) {
            return util.response_NOT_FOUND();
        }

        return util.responseOBJ_OK(users);
    }
}
