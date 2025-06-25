package com.example.ChileanStreetWear_backend.repository;


import com.example.ChileanStreetWear_backend.model.BrandCategory;
import com.example.ChileanStreetWear_backend.model.BrandCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BrandCategoryRepository extends JpaRepository<BrandCategory, BrandCategoryId> {


    List<BrandCategory> findByBrandId(UUID brandId);

    List<BrandCategory> findByCategoryId(UUID categoryId);

    boolean existsByBrandIdAndCategoryId(UUID brandId, UUID categoryId);
}

