package com.igap.registry.controllers.agent;

import com.igap.registry.entities.core.agent.Agent;
import com.igap.registry.services.core.agent.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/agents")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @PostMapping
    public ResponseEntity<Agent> createAgent(@RequestBody Agent agent) {
        return ResponseEntity.ok(agentService.saveAgent(agent));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agent> getAgentById(@PathVariable UUID id) {
        return agentService.findAgentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Agent>> getAllAgents() {
        return ResponseEntity.ok(agentService.findAllAgents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable UUID id, @RequestBody Agent agent) {
        if (!agentService.findAgentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agent.setId(id);
        return ResponseEntity.ok(agentService.updateAgent(agent));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable UUID id) {
        agentService.deleteAgentById(id);
        return ResponseEntity.noContent().build();
    }
}