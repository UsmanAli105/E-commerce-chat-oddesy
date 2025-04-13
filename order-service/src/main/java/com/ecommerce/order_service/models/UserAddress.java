package com.ecommerce.order_service.models;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.*;

import java.time.LocalDateTime;

@Table("user_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    @PrimaryKey
    String userId;
    String addressId;
    String addressLine;
    String city;
    String state;
    String zip;
    String country;
    String phone;
    String email;
    String isDefault;
}
