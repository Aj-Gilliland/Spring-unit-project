package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService UserService;
    @Autowired
    public UserController (UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/getAll")
    public List<User> getAll() { return UserService.getAll(); }

    @PostMapping
    public void createUser(@RequestBody User user) { UserService.insertUser(user); }
}
