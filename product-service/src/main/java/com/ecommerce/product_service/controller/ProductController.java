package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ✅ 1. Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ✅ 2. Get All Products Sorted by Newest (by UUID timestamp)
    @GetMapping("/newest")
    public List<Product> getAllProductsByNewest() {
        return productRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Product::getId).reversed()) // Assuming time-based UUID
                .collect(Collectors.toList());
    }

    // ✅ 3. Get Products by Category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getCategory() != null && p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    // ✅ 4. Filter by name, category, brand, rating >= minRating
    @GetMapping("/filter")
    public List<Product> filterProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double minRating
    ) {
        return productRepository.findAll()
                .stream()
                .filter(p -> name == null || p.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .filter(p -> brand == null || p.getBrand().equalsIgnoreCase(brand))
                .filter(p -> minRating == null || p.getRating() >= minRating)
                .collect(Collectors.toList());
    }

    // ✅ 5. Get Product by ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        return productRepository.findById(id).orElse(null);
    }

    // ✅ 6. Create Product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        if (product.getId() == null || product.getId().isEmpty()) {
            product.setId(UUID.randomUUID().toString());
        }
        return productRepository.save(product);
    }

    // ✅ 7. Update Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    updatedProduct.setId(existingProduct.getId());
                    return productRepository.save(updatedProduct);
                })
                .orElse(null);
    }

    // ✅ 8. Delete Product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }
}
