package com.ecommerce.order_service.models;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table("orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @PrimaryKey
    private String id;

    private String userId;
    private String status;
    private Long totalAmount;
    private Boolean PaymentStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
