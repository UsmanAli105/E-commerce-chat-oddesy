package com.ecommerce.user_service.Repository;

import com.ecommerce.user_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
