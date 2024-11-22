package com.igap.registry.controllers.agent;

import com.igap.registry.entities.core.agent.EmergencyContact;
import com.igap.registry.services.agent.EmergencyContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/emergency-contacts")
@RequiredArgsConstructor
public class EmergencyContactController {

    private final EmergencyContactService emergencyContactService;

    @PostMapping
    public ResponseEntity<EmergencyContact> createEmergencyContact(@RequestBody EmergencyContact emergencyContact) {
        return ResponseEntity.ok(emergencyContactService.saveEmergencyContact(emergencyContact));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyContact> getEmergencyContactById(@PathVariable UUID id) {
        return emergencyContactService.findEmergencyContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmergencyContact>> getAllEmergencyContacts() {
        return ResponseEntity.ok(emergencyContactService.findAllEmergencyContacts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmergencyContact> updateEmergencyContact(@PathVariable UUID id, @RequestBody EmergencyContact emergencyContact) {
        if (!emergencyContactService.findEmergencyContactById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        emergencyContact.setId(id);
        return ResponseEntity.ok(emergencyContactService.updateEmergencyContact(emergencyContact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmergencyContact(@PathVariable UUID id) {
        emergencyContactService.deleteEmergencyContactById(id);
        return ResponseEntity.noContent().build();
    }
}