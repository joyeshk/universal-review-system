package com.jk.universalreview.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getInfo")
    public String getInfo(){
        return "You have reached users API";
    }

    @GetMapping("/{user_id}")
    public String getUser(@PathVariable("user_id") String user_id){
        return user_id;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@RequestParam("user_id") String user_id){
        userService.deleteUser(user_id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @PostMapping("/updateEmail")
    public void updateEmail(User user){
        userService.updateEmail(user);
    }
}
