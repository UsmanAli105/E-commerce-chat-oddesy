package com.ecommerce.product_service.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.*;

@Table("products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @PrimaryKey
    private String id;

    private String name;
    private String description;
    private double price;
    private String category;
    private int stock;
    private String brand;
    private double rating;
    private String imageUrl;
}
