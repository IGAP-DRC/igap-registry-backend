package com.igap.registry.controllers.location;

import com.igap.registry.entities.core.location.Municipality;
import com.igap.registry.services.core.location.MunicipalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/municipalities")
@RequiredArgsConstructor
public class MunicipalityController {

    private final MunicipalityService municipalityService;

    @PostMapping
    public ResponseEntity<Municipality> createMunicipality(@RequestBody Municipality municipality) {
        return ResponseEntity.ok(municipalityService.saveMunicipality(municipality));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipality> getMunicipalityById(@PathVariable UUID id) {
        return municipalityService.getMunicipalityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Municipality>> getAllMunicipalities() {
        return ResponseEntity.ok(municipalityService.getAllMunicipalities());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMunicipality(@PathVariable UUID id) {
        municipalityService.deleteMunicipality(id);
        return ResponseEntity.noContent().build();
    }
}