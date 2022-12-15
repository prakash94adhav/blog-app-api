package com.blog.controller;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDTO;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //post-create user
    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    //PUT-update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable("userId") int userId) {
        UserDTO updatedUser = this.userService.updateUser(userDTO, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //DELETE-delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") int userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted successfully", false), HttpStatus.OK);
    }

    //GET-get user
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> getAllUsers = this.userService.getAllUsers();
        return new ResponseEntity<>(getAllUsers, HttpStatus.OK);
    }

    //GET-single user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getSingleUser(@PathVariable int userId) {
        UserDTO userDTO = this.userService.getUserById(userId);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
