package com.ecommerce.user_service.Repository;

import com.ecommerce.user_service.models.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
}
