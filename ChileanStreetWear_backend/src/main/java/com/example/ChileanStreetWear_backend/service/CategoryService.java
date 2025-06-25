package com.example.ChileanStreetWear_backend.service;

import com.example.ChileanStreetWear_backend.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {


    List<Category> getAllCategories();

    Optional<Category> getCategoryById(UUID id);

    Optional<Category> getCategoryByName(String name);

    Category createCategory(Category category);

    Category updateCategory(UUID id, Category updatedCategory);

    void deleteCategory(UUID id);
}
