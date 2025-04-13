package com.ecommerce.product_service.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.*;

@Table("brand")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @PrimaryKey
    private String id;

    private String name;
    private String description;
}
