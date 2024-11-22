package com.igap.registry.controllers.agent.education;

import com.igap.registry.entities.core.agent.education.LevelEducation;
import com.igap.registry.services.agent.education.LevelEducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/level-educations")
@RequiredArgsConstructor
public class LevelEducationController {

    private final LevelEducationService levelEducationService;

    @PostMapping
    public ResponseEntity<LevelEducation> createLevelEducation(@RequestBody LevelEducation levelEducation) {
        return ResponseEntity.ok(levelEducationService.saveLevelEducation(levelEducation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LevelEducation> getLevelEducationById(@PathVariable UUID id) {
        return levelEducationService.findLevelEducationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LevelEducation>> getAllLevelEducations() {
        return ResponseEntity.ok(levelEducationService.findAllLevelEducations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LevelEducation> updateLevelEducation(@PathVariable UUID id, @RequestBody LevelEducation levelEducation) {
        if (!levelEducationService.findLevelEducationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        levelEducation.setId(id);
        return ResponseEntity.ok(levelEducationService.updateLevelEducation(levelEducation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLevelEducation(@PathVariable UUID id) {
        levelEducationService.deleteLevelEducationById(id);
        return ResponseEntity.noContent().build();
    }
}