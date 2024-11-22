package com.igap.registry.controllers.agent;

import com.igap.registry.entities.core.agent.CommissionAffectation;
import com.igap.registry.services.agent.CommissionAffectationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/commission-affectations")
@RequiredArgsConstructor
public class CommissionAffectationController {

    private final CommissionAffectationService commissionAffectationService;

    @PostMapping
    public ResponseEntity<CommissionAffectation> createCommissionAffectation(@RequestBody CommissionAffectation commissionAffectation) {
        return ResponseEntity.ok(commissionAffectationService.saveCommissionAffectation(commissionAffectation));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommissionAffectation> getCommissionAffectationById(@PathVariable UUID id) {
        return commissionAffectationService.findCommissionAffectationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CommissionAffectation>> getAllCommissionAffectations() {
        return ResponseEntity.ok(commissionAffectationService.findAllCommissionAffectations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommissionAffectation> updateCommissionAffectation(@PathVariable UUID id,
                                                                             @RequestBody CommissionAffectation commissionAffectation) {
        if (!commissionAffectationService.findCommissionAffectationById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        commissionAffectation.setId(id);
        return ResponseEntity.ok(commissionAffectationService.updateCommissionAffectation(commissionAffectation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommissionAffectation(@PathVariable UUID id) {
        commissionAffectationService.deleteCommissionAffectationById(id);
        return ResponseEntity.noContent().build();
    }
}