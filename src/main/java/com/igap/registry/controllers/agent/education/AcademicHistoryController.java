package com.igap.registry.controllers.agent.education;

import com.igap.registry.entities.core.agent.education.AcademicHistory;
import com.igap.registry.services.agent.education.AcademicHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/academic-histories")
@RequiredArgsConstructor
public class AcademicHistoryController {

    private final AcademicHistoryService academicHistoryService;

    @PostMapping
    public ResponseEntity<AcademicHistory> createAcademicHistory(@RequestBody AcademicHistory academicHistory) {
        return ResponseEntity.ok(academicHistoryService.saveAcademicHistory(academicHistory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicHistory> getAcademicHistoryById(@PathVariable UUID id) {
        return academicHistoryService.findAcademicHistoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AcademicHistory>> getAllAcademicHistories() {
        return ResponseEntity.ok(academicHistoryService.findAllAcademicHistories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicHistory> updateAcademicHistory(@PathVariable UUID id,
                                                                 @RequestBody AcademicHistory academicHistory) {
        if (!academicHistoryService.findAcademicHistoryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        academicHistory.setId(id);
        return ResponseEntity.ok(academicHistoryService.updateAcademicHistory(academicHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicHistory(@PathVariable UUID id) {
        academicHistoryService.deleteAcademicHistoryById(id);
        return ResponseEntity.noContent().build();
    }
}