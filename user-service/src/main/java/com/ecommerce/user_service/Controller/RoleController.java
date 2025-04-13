package com.ecommerce.user_service.Controller;

import com.ecommerce.user_service.Repository.RolesRepository;
import com.ecommerce.user_service.models.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RolesRepository roleRepository;

    @GetMapping
    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    @PostMapping
    public Roles createRole(@RequestBody Roles role) {
        return roleRepository.save(role);
    }

    @GetMapping("/{id}")
    public Roles getRoleById(@PathVariable Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }
}
