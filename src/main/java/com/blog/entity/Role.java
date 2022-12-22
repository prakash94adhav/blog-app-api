package com.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;

    @Id
    private int id;
    private String name;

}
