package com.devmare.user.service.controller;

import com.devmare.user.service.entity.User;
import com.devmare.user.service.payload.ApiResponse;
import com.devmare.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserService userService;

    //? http://localhost:8081/user/
    @PostMapping("/")
    public ResponseEntity<User> createUser(
            @RequestBody User user
    ) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    //? http://localhost:8081/user/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(
            @PathVariable String userId
    ) {
        User currentUser = userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(currentUser);
    }

    //? http://localhost:8081/user/
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.CREATED).body(allUser);
    }

    //? http://localhost:8081/user/{userId}
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(
            @RequestBody User user,
            @PathVariable String userId
    ) {
        User updatedUser = userService.updateUser(user, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
    }

    //? http://localhost:8081/user/{userId}
    @DeleteMapping("/{userID}")
    public ApiResponse deleteUser(@PathVariable String userID) {
        userService.deleteUser(userID);
        return new ApiResponse("User deleted successfully with id: " + userID, true, HttpStatus.OK);
    }
}
