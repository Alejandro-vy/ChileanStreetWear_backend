package com.example.ChileanStreetWear_backend.service.impl;


import com.example.ChileanStreetWear_backend.model.Brand;
import com.example.ChileanStreetWear_backend.model.BrandCategory;
import com.example.ChileanStreetWear_backend.model.BrandCategoryId;
import com.example.ChileanStreetWear_backend.model.Category;
import com.example.ChileanStreetWear_backend.repository.BrandCategoryRepository;
import com.example.ChileanStreetWear_backend.repository.BrandRepository;
import com.example.ChileanStreetWear_backend.repository.CategoryRepository;
import com.example.ChileanStreetWear_backend.service.BrandCategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandCategoryServiceImpl implements BrandCategoryService {

    private final BrandCategoryRepository brandCategoryRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public void assignCategoryToBrand(UUID brandId, UUID categoryId) {
        if (brandCategoryRepository.existsByBrandIdAndCategoryId(brandId, categoryId)) {
            return; // ya está asignado, no hacer nada
        }

        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        BrandCategory association = BrandCategory.builder()
                .id(new BrandCategoryId(brandId, categoryId))
                .brand(brand)
                .category(category)
                .build();

        brandCategoryRepository.save(association);
    }

    @Override
    public void removeCategoryFromBrand(UUID brandId, UUID categoryId) {
        BrandCategoryId id = new BrandCategoryId(brandId, categoryId);
        if (!brandCategoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Association not found");
        }
        brandCategoryRepository.deleteById(id);
    }

    @Override
    public List<UUID> getCategoryIdsByBrand(UUID brandId) {
        return brandCategoryRepository.findByBrandId(brandId).stream()
                .map(assoc -> assoc.getCategory().getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<UUID> getBrandIdsByCategory(UUID categoryId) {
        return brandCategoryRepository.findByCategoryId(categoryId).stream()
                .map(assoc -> assoc.getBrand().getId())
                .collect(Collectors.toList());
    }
}
