package com.igap.registry.controllers.location;

import com.igap.registry.entities.core.location.Neighborhood;
import com.igap.registry.services.location.NeighborhoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */

@RestController
@RequestMapping("/api/neighborhoods")
@RequiredArgsConstructor
public class NeighborhoodController {

    private final NeighborhoodService neighborhoodService;

    @PostMapping
    public ResponseEntity<Neighborhood> createNeighborhood(@RequestBody Neighborhood neighborhood) {
        return ResponseEntity.ok(neighborhoodService.saveNeighborhood(neighborhood));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Neighborhood> getNeighborhoodById(@PathVariable UUID id) {
        return neighborhoodService.getNeighborhoodById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Neighborhood>> getAllNeighborhoods() {
        return ResponseEntity.ok(neighborhoodService.getAllNeighborhoods());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNeighborhood(@PathVariable UUID id) {
        neighborhoodService.deleteNeighborhood(id);
        return ResponseEntity.noContent().build();
    }
}