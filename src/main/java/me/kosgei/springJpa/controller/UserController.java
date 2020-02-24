package me.kosgei.springJpa.controller;

import me.kosgei.springJpa.model.User;
import me.kosgei.springJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello(){
        return  "Hello friend";
    }

    @PostMapping("/new/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("user/delete")
    public  void deleteUser(@RequestBody User user){
        userService.deleteUser(user);

    }
}
