package com.ecommerce.user_service.Controller;

import com.ecommerce.user_service.Repository.RolePermissionsRepository;
import com.ecommerce.user_service.models.RolePermissions;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/role-permissions")
@RequiredArgsConstructor
public class RolePermissionsController {

    private final RolePermissionsRepository rolePermissionsRepository;

    @GetMapping
    public List<RolePermissions> getAllRolePermissions() {
        return rolePermissionsRepository.findAll();
    }

    @PostMapping
    public RolePermissions assignPermissionToRole(@RequestBody RolePermissions rolePermissions) {
        return rolePermissionsRepository.save(rolePermissions);
    }

    @GetMapping("/{id}")
    public RolePermissions getRolePermissionById(@PathVariable Long id) {
        return rolePermissionsRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteRolePermission(@PathVariable Long id) {
        rolePermissionsRepository.deleteById(id);
    }
}
