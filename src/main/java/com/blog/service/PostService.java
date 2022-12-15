package com.blog.service;

import com.blog.entity.Post;
import com.blog.payloads.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO,int userId,int catId);

    Post updatePost(PostDTO postDTO, int postId);

    void deletePost(int postId);

    List<Post> getAllPost();

    Post getPostByPostId(int postId);

    List<Post> getPostsByCategory(int catId);

    List<Post> getPostByUserId(int userId);

    List<Post> searchPost(String post);

}
