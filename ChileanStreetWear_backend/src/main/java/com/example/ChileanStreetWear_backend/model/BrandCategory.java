package com.example.ChileanStreetWear_backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "brand_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BrandCategory implements Serializable {



    @EmbeddedId
    private BrandCategoryId id;

    @ManyToOne
    @MapsId("brandId")
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;
}
