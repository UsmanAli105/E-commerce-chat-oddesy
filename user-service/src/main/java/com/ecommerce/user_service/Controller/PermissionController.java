package com.ecommerce.user_service.Controller;

import com.ecommerce.user_service.Repository.PermissionsRepository;
import com.ecommerce.user_service.models.Permissions;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionsRepository permissionRepository;

    @GetMapping
    public List<Permissions> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @PostMapping
    public Permissions createPermission(@RequestBody Permissions permission) {
        return permissionRepository.save(permission);
    }

    @GetMapping("/{id}")
    public Permissions getPermissionById(@PathVariable Long id) {
        return permissionRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deletePermission(@PathVariable Long id) {
        permissionRepository.deleteById(id);
    }
}
