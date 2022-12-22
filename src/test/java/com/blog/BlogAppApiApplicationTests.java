package com.blog;

import com.blog.entity.User;
import com.blog.payloads.UserDTO;
import com.blog.repository.UserRepository;
import com.blog.service.UserService;
import com.blog.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogAppApiApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    @MockBean
    private UserRepository userRepository;

    @Test
    void getUserTest() {
        when(userRepository.findAll())
                .thenReturn((
                        Stream.of(new User(10, "Ram", "Ram@gamil.com", "Ram@12", "ETL Dev", new ArrayList<>()))
                                .collect(Collectors.toList())));
        Assert.assertEquals(Arrays.asList(new UserDTO(10, "Ram", "Ram@gamil.com", "Ram@12", "ETL Dev")), userService.getAllUsers());
    }

    @Test
    void saveUserTest() {
        UserDTO user = new UserDTO(10, "Ram", "Ram@gamil.com", "Ram@12", "ETL Dev");
        when(userRepository.save(this.modelMapper.map(user, User.class))).thenReturn(this.modelMapper.map(user, User.class));
        Assert.assertEquals(user, userService.createUser(modelMapper.map(user, UserDTO.class)));
    }
}
