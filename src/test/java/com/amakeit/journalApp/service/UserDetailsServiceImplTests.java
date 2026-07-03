package com.amakeit.journalApp.service;
import com.amakeit.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.ArrayList;
import static org.mockito.Mockito.*;


public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest() {

        com.amakeit.journalApp.entity.User mockUser = new com.amakeit.journalApp.entity.User();
                mockUser.setRoles(new ArrayList<>());

        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(mockUser);

        UserDetails user = userDetailsService.loadUserByUsername("ram");

        Assertions.assertNotNull(user);
    }
}







//    @Test
//    void loadUserByUsernameTest(){
//        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//                .thenReturn((com.amakeit.journalApp.entity.User)
//                        User.builder().username("ram").password("abc")
//                                .roles(String.valueOf(new ArrayList<>())).build());
//        UserDetails user = userDetailsService.loadUserByUsername("ram");
//        Assertions.assertNotNull(user);
//    }

//void loadUserByUsernameTest(){
//
//    com.amakeit.journalApp.entity.User mockUser =
//            new com.amakeit.journalApp.entity.User("ram" , "abc");
//
//    mockUser.setUserName("ram");
//    mockUser.setPassword("abc");
//    mockUser.setRoles(new ArrayList<>());
//
//    when(userRepository.findByUserName(ArgumentMatchers.anyString()))
//            .thenReturn(mockUser);
//
//    UserDetails user = userDetailsService.loadUserByUsername("ram");
//
//    Assertions.assertNotNull(user);
//}

