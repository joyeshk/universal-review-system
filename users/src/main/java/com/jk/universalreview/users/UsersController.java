package com.jk.universalreview.users;

import com.jk.universalreview.users.DTO.UserDTO;
import com.jk.universalreview.users.DTO.emailChangeDTO;
import com.jk.universalreview.users.service.UserService;
import jakarta.validation.Valid;
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
    public UserDTO getUser(@PathVariable("user_id") String user_id){
        return userService.getUserDetails(user_id);
    }

    @PostMapping("/signup")
    public User signup(@RequestBody @Valid User user){
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
    public void updateEmail(@RequestBody @Valid emailChangeDTO userInfo){
        User user = new User();
        user.setUser_id(userInfo.getUser_id());
        user.setEmail(userInfo.getEmail());
        userService.updateEmail(user);
    }
}
