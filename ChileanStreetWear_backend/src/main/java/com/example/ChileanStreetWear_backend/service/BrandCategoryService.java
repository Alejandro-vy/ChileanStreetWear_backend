package com.example.ChileanStreetWear_backend.service;

import java.util.List;
import java.util.UUID;

public interface BrandCategoryService {

    void assignCategoryToBrand(UUID brandId, UUID categoryId);

    void removeCategoryFromBrand(UUID brandId, UUID categoryId);

    List<UUID> getCategoryIdsByBrand(UUID brandId);

    List<UUID> getBrandIdsByCategory(UUID categoryId);
}
