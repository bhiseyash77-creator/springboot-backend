package com.example.yashbhise.Controller;

import com.example.yashbhise.Model.User;
import com.example.yashbhise.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.adduser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        boolean success = userService.loginUser(
                user.getUsername(),
                user.getPassword()
        );

        if (success) {
            return ResponseEntity.ok("Login Success");
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }
}