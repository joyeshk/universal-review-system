package com.jk.universalreview.users.service;

import com.jk.universalreview.users.DTO.UserDTO;
import com.jk.universalreview.users.DTO.external.Reviews;
import com.jk.universalreview.users.User;
import com.jk.universalreview.users.UserRepository;
import com.jk.universalreview.users.service.external.ReviewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewsService reviewsService;

    Logger log = LoggerFactory.getLogger(this.getClass());
    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @CacheEvict(value = "user", key = "#user_id")
    public void deleteUser(String user_id){
        userRepository.deleteById(user_id);
    }

    @CachePut(value = "user", key = "#user.user_id")
    public void updateUser(User user){
        userRepository.save(user);
    }
    @Transactional
    public void updateEmail(User user){
        String user_id = user.getUser_id();
        String email = user.getEmail();
        userRepository.updateEmail(user_id,email);
    }

    @Cacheable(value = "user", key = "#user_id")
    public UserDTO getUserDetails(String user_id){
        User user =  userRepository.findById(user_id).orElse(null);
        UserDTO userDTO = new UserDTO(user);
        List<Reviews> reviews = reviewsService.getUserReviews(user_id);
        log.debug(reviews.toString());
        userDTO.setReviews(reviews);
        return userDTO;
    }
}
