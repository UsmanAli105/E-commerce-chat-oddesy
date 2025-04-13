package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.model.Brand;
import com.ecommerce.product_service.repository.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    // ✅ 1. Get All Products
    @GetMapping
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable String id) {
        return brandRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Brand addProduct(@RequestBody Brand Brand) {
        if (Brand.getId() == null || Brand.getId().isEmpty()) {
            Brand.setId(UUID.randomUUID().toString());
        }
        return brandRepository.save(Brand);
    }

    // ✅ 7. Update Product
    @PutMapping("/{id}")
    public Brand updateProduct(@PathVariable String id, @RequestBody Brand updatedBrand) {
        return brandRepository.findById(id)
                .map(existingBrand -> {
                    updatedBrand.setId(existingBrand.getId());
                    return brandRepository.save(updatedBrand);
                })
                .orElse(null);
    }

    // ✅ 8. Delete Product
    @DeleteMapping("/{id}")
    public void deleteBrand(@PathVariable String id) {
        brandRepository.deleteById(id);
    }
}
