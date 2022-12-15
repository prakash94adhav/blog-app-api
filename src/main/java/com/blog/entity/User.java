package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER_TB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_ID", nullable = false, length = 100)
    private int id;
    @Column(name = "USR_NAME")
    private String name;
    @Column(name = "USR_EMAIL")
    private String email;
    @Column(name = "USR_PASSWORD")
    private String password;
    @Column(name = "USR_ABOUT")
    private String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();
}