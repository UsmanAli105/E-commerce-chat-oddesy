package com.ecommerce.user_service.Repository;

import com.ecommerce.user_service.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}
