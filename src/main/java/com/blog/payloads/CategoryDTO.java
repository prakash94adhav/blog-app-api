package com.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {


    private int catId;
    @NotBlank
    @Size(min = 4)
    private String catTitle;

    @NotBlank
    @Size(min = 10)
    private String catDesc;
}
