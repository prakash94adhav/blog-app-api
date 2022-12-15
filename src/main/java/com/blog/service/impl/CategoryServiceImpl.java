package com.blog.service.impl;

import com.blog.entity.Category;
import com.blog.exeption.ResourceNotFoundException;
import com.blog.payloads.CategoryDTO;
import com.blog.repository.CategoryRepository;
import com.blog.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.blog.CategoryConstant.CATEGORY;
import static com.blog.CategoryConstant.CAT_ID;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category cat = this.modelMapper.map(categoryDTO, Category.class);
        Category addedCat = this.categoryRepository.save(cat);
        return this.modelMapper.map(addedCat, CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, int catId) {
        Category cat = this.categoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY, "cat Id", catId));

        cat.setCatTitle(categoryDTO.getCatTitle());
        cat.setCatDesc(cat.getCatDesc());

        Category updatedCat = this.categoryRepository.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDTO.class);
    }

    @Override
    public void deleteCatory(int catId) {
        Category cat = this.categoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY, CAT_ID, catId));
        this.categoryRepository.delete(cat);
    }

    @Override
    public CategoryDTO getSingleCategory(int catId) {
        Category cat = this.categoryRepository.findById(catId)
                .orElseThrow(() -> new ResourceNotFoundException(CATEGORY, CAT_ID, catId));
        return this.modelMapper.map(cat, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();

        return categories.stream()
                .map(cat -> this.modelMapper.map(cat, CategoryDTO.class))
                .collect(Collectors.toList());
    }

}
