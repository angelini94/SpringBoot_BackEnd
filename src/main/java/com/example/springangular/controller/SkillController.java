package com.example.springangular.controller;

import com.example.springangular.model.Skill;
import com.example.springangular.repository.SkillRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/skills")
public class SkillController {

    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    /** Return all SKILLS */
    @GetMapping("")
    public ResponseEntity<List<Skill>> getSkillsList() {
        return ResponseEntity.ok(skillRepository.findAll());
    }
}
