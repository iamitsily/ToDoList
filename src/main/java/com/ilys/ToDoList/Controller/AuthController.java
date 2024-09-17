package com.ilys.ToDoList.Controller;

import com.ilys.ToDoList.Model.User;
import com.ilys.ToDoList.Service.iUserService;
import com.ilys.ToDoList.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private iUserService userService;
    @Autowired
    private Util util;
    @RequestMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        return util.responseOBJ_OK(userService.getUserByCredentials(user));
    }
}
