package com.blog.service;

import com.blog.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO,int catId);

    void deleteCatory(int catId);

    CategoryDTO getSingleCategory(int catId);

    List<CategoryDTO> getAllCategories();
}
