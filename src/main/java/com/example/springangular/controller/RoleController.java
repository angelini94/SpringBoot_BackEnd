package com.example.springangular.controller;

import com.example.springangular.model.Role;
import com.example.springangular.repository.RoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /** Return all ROLES */
    @GetMapping("")
    public ResponseEntity<List<Role>> getRolesList() {
        return ResponseEntity.ok(roleRepository.findAll());
    }
}
