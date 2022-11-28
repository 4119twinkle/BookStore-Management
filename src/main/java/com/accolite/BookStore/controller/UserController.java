package com.accolite.BookStore.controller;

import com.accolite.BookStore.model.User;
import com.accolite.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    private ResponseEntity<List<User>> getAllUsers(){

        return ResponseEntity.ok().body(this.userService.getUser());
    }
    @GetMapping("/user/{userId}")
    private User getUserById(@PathVariable long userId){
       return this.userService.getUserById(userId);
    }
    @PostMapping("/users")
    private ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok().body(this.userService.createUser(user));
    }
    @PutMapping("/user/{userId}")
    private ResponseEntity<User> updateUser(@PathVariable long userId,@RequestBody User user){
        user.setUser_id(userId);
        return  ResponseEntity.ok().body((this.userService.updateUser(user)));
    }
    // @PutMapping

    @DeleteMapping("/user/{userId}")
    private HttpStatus deleteUser(@PathVariable long userId){
        this.userService.deleteUser(userId);
        return  HttpStatus.OK;
    }
    //usecase2

    @GetMapping("/user/wallet/{user_id}")
    private ResponseEntity<Double> getWallet(@RequestBody User u){
        return ResponseEntity.ok().body(this.userService.getwallet(u));
    }

    //Adding amount to the wallet
    @PutMapping("/user/wallet/{userId}")
    private ResponseEntity<User> updateWallet(@PathVariable long userId, @RequestBody User user){
        user.setUser_id(userId);
        return ResponseEntity.ok().body(this.userService.updateWallet(user));
    }
    @PutMapping("/user/suspend/{userId}")
    private ResponseEntity<User> suspendUser(@PathVariable long userId, @RequestBody User user){
        user.setUser_id(userId);
        return ResponseEntity.ok().body(this.userService.suspendUser(user));
    }

}
