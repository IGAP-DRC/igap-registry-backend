package com.igap.registry.controllers.agent;

import com.igap.registry.entities.core.agent.AgentContact;
import com.igap.registry.services.core.agent.AgentContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/agent-contacts")
@RequiredArgsConstructor
public class AgentContactController {

    private final AgentContactService agentContactService;

    @PostMapping
    public ResponseEntity<AgentContact> createAgentContact(@RequestBody AgentContact agentContact) {
        return ResponseEntity.ok(agentContactService.saveAgentContact(agentContact));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentContact> getAgentContactById(@PathVariable UUID id) {
        return agentContactService.findAgentContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AgentContact>> getAllAgentContacts() {
        return ResponseEntity.ok(agentContactService.findAllAgentContacts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentContact> updateAgentContact(@PathVariable UUID id,
                                                           @RequestBody AgentContact agentContact) {
        if (!agentContactService.findAgentContactById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agentContact.setId(id);
        return ResponseEntity.ok(agentContactService.updateAgentContact(agentContact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgentContact(@PathVariable UUID id) {
        agentContactService.deleteAgentContactById(id);
        return ResponseEntity.noContent().build();
    }
}