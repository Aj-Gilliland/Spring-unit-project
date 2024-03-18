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

    @GetMapping("/getAll")//get all users
    public List<User> getAll() { return UserService.getAll(); }

    @PostMapping//makes a user
    @GetMapping("/makeUser")
    public void createUser(@RequestBody User user) { UserService.insertUser(user); }

    @PutMapping(path = "/addUserToChatroom/{userId}/{chatroomId}")//add a user to chatroom
    public void addUserToChatroom(
            @PathVariable("userId") Long userId,
            @PathVariable("chatroomId") Long chatroomId){
        UserService.addUserToChatroom(userId,chatroomId);
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
       return UserService.getUser(userId);
    }//view one user by id

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        UserService.deleteUser(userId);
    }// delete a user by id
}