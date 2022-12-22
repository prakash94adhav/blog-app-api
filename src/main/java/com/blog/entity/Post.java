package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "POST_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "POST_ID")
    private int postId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "IMAGE_NAME")
    private String imageName;
    @Column(name = "ADD_DATE")
    private Date addDate;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

}
