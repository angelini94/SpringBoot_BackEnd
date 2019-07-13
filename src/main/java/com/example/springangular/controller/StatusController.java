package com.example.springangular.controller;

import com.example.springangular.model.Status;
import com.example.springangular.repository.StatusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/statuses")
public class StatusController {

    private final StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    /** Return all STATUSES */
    @GetMapping("")
    public ResponseEntity<List<Status>> getStatusesList() {
        return ResponseEntity.ok(statusRepository.findAll());
    }
}
