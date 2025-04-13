package com.ecommerce.order_service.Repository;

import com.ecommerce.order_service.models.UserAddress;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserAddressRepository extends CassandraRepository<UserAddress, Long> {
}
