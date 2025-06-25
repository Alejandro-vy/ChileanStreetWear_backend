package com.example.ChileanStreetWear_backend.controller;


import com.example.ChileanStreetWear_backend.service.BrandCategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BrandCategoryController {

    private final BrandCategoryService brandCategoryService;

    // Asociar una categoría a una marca
    @PostMapping("/brands/{brandId}/categories/{categoryId}")
    public ResponseEntity<Void> assignCategoryToBrand(@PathVariable UUID brandId,
                                                      @PathVariable UUID categoryId) {
        try {
            brandCategoryService.assignCategoryToBrand(brandId, categoryId);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una categoría de una marca
    @DeleteMapping("/brands/{brandId}/categories/{categoryId}")
    public ResponseEntity<Void> removeCategoryFromBrand(@PathVariable UUID brandId,
                                                        @PathVariable UUID categoryId) {
        try {
            brandCategoryService.removeCategoryFromBrand(brandId, categoryId);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Obtener IDs de categorías asociadas a una marca
    @GetMapping("/brands/{brandId}/categories")
    public ResponseEntity<List<UUID>> getCategoryIdsByBrand(@PathVariable UUID brandId) {
        return ResponseEntity.ok(brandCategoryService.getCategoryIdsByBrand(brandId));
    }

    // Obtener IDs de marcas asociadas a una categoría
    @GetMapping("/categories/{categoryId}/brands")
    public ResponseEntity<List<UUID>> getBrandIdsByCategory(@PathVariable UUID categoryId) {
        return ResponseEntity.ok(brandCategoryService.getBrandIdsByCategory(categoryId));
    }
}
