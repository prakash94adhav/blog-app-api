package com.blog.service;

import com.blog.entity.Post;
import com.blog.payloads.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO, int userId, int catId);

    Post updatePost(PostDTO postDTO, int postId);

    void deletePost(int postId);

    List<PostDTO> getAllPost();

    PostDTO getPostByPostId(int postId);

    List<PostDTO> getPostsByCategory(int catId);

    List<PostDTO> getPostByUserId(int userId);

    List<PostDTO> searchPost(String post);

}
