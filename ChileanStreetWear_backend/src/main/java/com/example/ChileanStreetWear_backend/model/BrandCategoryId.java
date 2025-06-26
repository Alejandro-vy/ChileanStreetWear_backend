package com.example.ChileanStreetWear_backend.model;


import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BrandCategoryId implements Serializable {

    private UUID brandId;
    private UUID categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrandCategoryId that)) return false;
        return Objects.equals(brandId, that.brandId) &&
                Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, categoryId);
    }
}
