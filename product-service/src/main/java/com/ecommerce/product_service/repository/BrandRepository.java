package com.ecommerce.product_service.repository;

import com.ecommerce.product_service.model.Brand;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BrandRepository extends CassandraRepository<Brand, String> { }