package com.blog.service.impl;

import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exeption.ResourceNotFoundException;
import com.blog.payloads.PostDTO;
import com.blog.repository.CategoryRepository;
import com.blog.repository.PostRepository;
import com.blog.repository.UserRepository;
import com.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.blog.CategoryConstant.CATEGORY;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO, int userId, int catId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Category category = this.categoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY, "cat Id", catId));


        Post post = this.modelMapper.map(postDTO, Post.class);
        post.setImageName("default.png");
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepository.save(post);
        return this.modelMapper.map(newPost, PostDTO.class);
    }

    @Override
    public Post updatePost(PostDTO postDTO, int postId) {
        return null;
    }

    @Override
    public void deletePost(int postId) {
//TODO delete
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostByPostId(int postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(int catId) {
        return null;
    }

    @Override
    public List<Post> getPostByUserId(int userId) {
        return null;
    }

    @Override
    public List<Post> searchPost(String post) {
        return null;
    }
}
