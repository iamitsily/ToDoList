package com.ilys.ToDoList.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class Util {

    @Autowired
    private JWTUtil jwtUtil;
    public boolean validateToken(String token){
        if (token == null || token.isEmpty()){
            return false;
        }
        String userId = jwtUtil.getKey(token);
        return userId != null;
    }

    public <T> ResponseEntity<T> responseOBJ_OK(T body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
    public <T> ResponseEntity<T> responseOBJ_NOT_FOUND(T body) {
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    public <T> ResponseEntity<T> responseOBJ_BAD_REQUEST(T body) {
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    public <T> ResponseEntity<T> responseOBJ_CREATED(T body) {
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }
    public <T> ResponseEntity<T> responseOBJ_CONFLICT(T body) {
        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
    public <T> ResponseEntity<T> responseOBJ_INTERNAL_SERVER_ERROR(T body) {
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    public <T> ResponseEntity<T> response_OK(T text) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public <T> ResponseEntity<T> response_NOT_FOUND() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public <T> ResponseEntity<T> response_BAD_REQUEST() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    public <T> ResponseEntity<T> response_CREATED() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    public <T> ResponseEntity<T> response_CONFLICT() {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
    public <T> ResponseEntity<T> response_INTERNAL_SERVER_ERROR() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
