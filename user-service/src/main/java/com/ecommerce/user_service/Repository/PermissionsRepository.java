package com.ecommerce.user_service.Repository;

import com.ecommerce.user_service.models.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionsRepository extends JpaRepository<Permissions, Long> {
}
