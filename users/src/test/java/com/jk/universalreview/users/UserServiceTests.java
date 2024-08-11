package com.jk.universalreview.users;


import com.jk.universalreview.users.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTests {
    private User user;

    //the class we need to mock is marked with mockbean
    @MockBean UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    void getAllUsers(){
        User user1 = new User("1","Adam","Fakeuser","adam@awd.com","password");
        User user2 = new User("2","Alex","Fakeuser","alex@awd.com","password");

        when(userRepository.findAll()).thenReturn(List.of(user1,user2));

        List<User> userList = userService.getAllUsers();
        assertEquals(2,userList.size());
        assert(!userList.isEmpty());
    }
}
