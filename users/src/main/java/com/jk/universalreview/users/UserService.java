package com.jk.universalreview.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public void deleteUser(String user_id){
        userRepository.deleteById(user_id);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }
    @Transactional
    public void updateEmail(User user){
        String user_id = user.getUser_id();
        String email = user.getEmail();
        userRepository.updateEmail(user_id,email);
    }
}
