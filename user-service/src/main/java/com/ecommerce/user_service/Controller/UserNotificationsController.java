package com.ecommerce.user_service.Controller;

import com.ecommerce.user_service.Repository.UserNotificationsRepository;
import com.ecommerce.user_service.Repository.UserRepository;
import com.ecommerce.user_service.models.User;
import com.ecommerce.user_service.models.UserNotifications;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class UserNotificationsController {

    private final UserNotificationsRepository userNotificationsRepository;
    private final UserRepository userRepository;

    @GetMapping
    public List<UserNotifications> getAllNotifications() {
        return userNotificationsRepository.findAll();
    }

    @PostMapping
    public UserNotifications createNotification(@RequestBody UserNotifications notification) {
        return userNotificationsRepository.save(notification);
    }

    @GetMapping("/{id}")
    public UserNotifications getNotificationById(@PathVariable Long id) {
        return userNotificationsRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteNotification(@PathVariable Long id) {
        userNotificationsRepository.deleteById(id);
    }
    @GetMapping("/user/{userId}")
    public List<UserNotifications> getNotificationsByUserId(@PathVariable Long userId) {
        return userNotificationsRepository.findUserNotificationsByUserUserId(userId);
    }
}
