package com.blog.controller;

import com.blog.payloads.PostDTO;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{catId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO,
                                              @PathVariable int userId,
                                              @PathVariable int catId) {
        return new ResponseEntity<>(this.postService.createPost(postDTO, userId, catId), HttpStatus.CREATED);
    }
}
