package com.ecommerce.user_service.Repository;

import com.ecommerce.user_service.models.RolePermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionsRepository extends JpaRepository<RolePermissions, Long> {
}
