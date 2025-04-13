package com.ecommerce.user_service.Repository;

import com.ecommerce.user_service.models.User;
import com.ecommerce.user_service.models.UserNotifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserNotificationsRepository extends JpaRepository<UserNotifications, Long> {
    List<UserNotifications> findUserNotificationsByUserUserId(Long userId);
}
