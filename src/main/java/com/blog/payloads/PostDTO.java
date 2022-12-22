package com.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO implements Serializable {

    private String title;
    private String content;
    private String imageName;
    private Date addDate;

    private CategoryDTO category;
    private UserDTO user;

}
