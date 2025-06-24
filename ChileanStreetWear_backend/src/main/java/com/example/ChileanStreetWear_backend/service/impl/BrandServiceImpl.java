package com.example.ChileanStreetWear_backend.service.impl;


import com.example.ChileanStreetWear_backend.model.Brand;
import com.example.ChileanStreetWear_backend.repository.BrandRepository;
import com.example.ChileanStreetWear_backend.service.BrandService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> getBrandById(UUID id) {
        return brandRepository.findById(id);
    }

    @Override
    public Optional<Brand> getBrandByName(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(UUID id, Brand updatedBrand) {
        Brand existing = brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brand not found"));

        existing.setName(updatedBrand.getName());
        existing.setLogoUrl(updatedBrand.getLogoUrl());
        existing.setWebsiteUrl(updatedBrand.getWebsiteUrl());
        existing.setDescription(updatedBrand.getDescription());

        return brandRepository.save(existing);
    }

    @Override
    public void deleteBrand(UUID id) {
        if (!brandRepository.existsById(id)) {
            throw new EntityNotFoundException("Brand not found");
        }
        brandRepository.deleteById(id);
    }
}
