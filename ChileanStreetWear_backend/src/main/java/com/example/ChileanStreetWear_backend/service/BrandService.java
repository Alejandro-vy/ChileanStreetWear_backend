package com.example.ChileanStreetWear_backend.service;


import com.example.ChileanStreetWear_backend.model.Brand;
import org.hibernate.query.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {

    List<Brand> getAllBrands();

    Optional<Brand> getBrandById(UUID id);

    Optional<Brand> getBrandByName(String name);

    Brand createBrand(Brand brand);

    Brand updateBrand(UUID id, Brand updatedBrand);

    void deleteBrand(UUID id);

}
