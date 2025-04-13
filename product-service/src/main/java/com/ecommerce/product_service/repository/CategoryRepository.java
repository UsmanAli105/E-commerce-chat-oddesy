package com.ecommerce.product_service.repository;

import com.ecommerce.product_service.model.Category;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface CategoryRepository extends CassandraRepository<Category, String> { }