package com.blog.payloads;

import com.blog.entity.Category;
import com.blog.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private String title;
    private String content;
    private String imageName;
    private Date addDate;

    private CategoryDTO category;
    private UserDTO user;

}
