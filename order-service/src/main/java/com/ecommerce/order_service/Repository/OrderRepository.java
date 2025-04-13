package com.ecommerce.order_service.Repository;
import com.ecommerce.order_service.models.Order;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface OrderRepository extends CassandraRepository<Order, Long> {
}
