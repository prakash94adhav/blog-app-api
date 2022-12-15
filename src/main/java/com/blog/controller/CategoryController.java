package com.blog.controller;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDTO;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable int catId) {
        return new ResponseEntity<>(this.categoryService.updateCategory(categoryDTO, catId), HttpStatus.OK);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") int catId) {
        this.categoryService.deleteCatory(catId);
        return new ResponseEntity<>(new ApiResponse("Category deleted successfully", false), HttpStatus.OK);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("catId") int catId) {
        CategoryDTO categoryDTO = this.categoryService.getSingleCategory(catId);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categoryDTOS = this.categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }
}
