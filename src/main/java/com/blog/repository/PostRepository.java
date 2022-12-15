package com.blog.repository;

import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);


}
