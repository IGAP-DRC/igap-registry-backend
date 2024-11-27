package com.igap.registry.controllers.agent.education;

import com.igap.registry.entities.core.agent.education.AcademicProgram;
import com.igap.registry.services.core.agent.education.AcademicProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/academic-programs")
@RequiredArgsConstructor
public class AcademicProgramController {

    private final AcademicProgramService academicProgramService;

    @PostMapping
    public ResponseEntity<AcademicProgram> createAcademicProgram(@RequestBody AcademicProgram academicProgram) {
        return ResponseEntity.ok(academicProgramService.saveAcademicProgram(academicProgram));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicProgram> getAcademicProgramById(@PathVariable UUID id) {
        return academicProgramService.findAcademicProgramById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AcademicProgram>> getAllAcademicPrograms() {
        return ResponseEntity.ok(academicProgramService.findAllAcademicPrograms());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicProgram> updateAcademicProgram(@PathVariable UUID id, @RequestBody AcademicProgram academicProgram) {
        if (!academicProgramService.findAcademicProgramById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        academicProgram.setId(id);
        return ResponseEntity.ok(academicProgramService.updateAcademicProgram(academicProgram));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicProgram(@PathVariable UUID id) {
        academicProgramService.deleteAcademicProgramById(id);
        return ResponseEntity.noContent().build();
    }
}