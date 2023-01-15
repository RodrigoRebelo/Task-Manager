package com.neff.controller;

import com.neff.exceptions.ErrorObject;
import com.neff.exceptions.UserErrorException;
import com.neff.model.User;
import com.neff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TaskController taskController;

    @GetMapping(value = "/api/users", consumes = {"*/*"})
    public List<User> getAllUsers () {
        try {
            return userService.getAllUsers();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/api/users/{id}", consumes = {"*/*"})
    public User getUser ( @PathVariable("id") int id) {
            return userService.getUserById(id);
    }

    @DeleteMapping(value = "/api/users/{id}", consumes = {"*/*"})
    public void deleteUser ( @PathVariable("id") int id){
        userService.delete(id);
    }

    @PostMapping(value = "/api/users", consumes = {"*/*"})
    public void saveUser (@RequestBody User user){
        userService.saveOrUpdate(user);
        //return user.getId();
    }

    @ExceptionHandler
    public ResponseEntity <ErrorObject> handleException (UserErrorException e) {
        ErrorObject eObject = new ErrorObject(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<ErrorObject>(eObject, HttpStatus.NOT_FOUND);
    }
}
