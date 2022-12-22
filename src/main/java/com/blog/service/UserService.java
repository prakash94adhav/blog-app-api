package com.blog.service;

import com.blog.payloads.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerNewUser(UserDTO userDTO);
    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user, int userId);

    UserDTO getUserById(int userId);

    List<UserDTO> getAllUsers();

    void deleteUser(int userId);

}
