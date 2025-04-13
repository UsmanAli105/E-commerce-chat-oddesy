package com.ecommerce.user_service.Controller;

import com.ecommerce.user_service.Repository.UserRolesRepository;
import com.ecommerce.user_service.models.UserRoles;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user-roles")
@RequiredArgsConstructor
public class UserRolesController {

    private final UserRolesRepository userRolesRepository;

    @GetMapping
    public List<UserRoles> getAllUserRoles() {
        return userRolesRepository.findAll();
    }

    @PostMapping
    public UserRoles assignRoleToUser(@RequestBody UserRoles userRoles) {
        return userRolesRepository.save(userRoles);
    }

    @GetMapping("/{id}")
    public UserRoles getUserRoleById(@PathVariable Long id) {
        return userRolesRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable Long id) {
        userRolesRepository.deleteById(id);
    }
}
