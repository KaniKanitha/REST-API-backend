package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService us;

    @PostMapping("/postu")
    public ResponseEntity<User> add(@RequestBody User u) {
        User newuser = us.create(u);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @GetMapping("/getu")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> obj = us.getAlldetails();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/userdata")
    public ResponseEntity<List<User>> getUserData() {
        return new ResponseEntity<>(us.getAlldetails(), HttpStatus.OK);
    }

    @PutMapping("/putu/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") int id, @RequestBody User user) {
        if (us.updateDetails(id, user)) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delu/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int id) {
        if (us.deleteUser(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
