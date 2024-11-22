package com.igap.registry.controllers.agent;

import com.igap.registry.entities.core.agent.AgentGrade;
import com.igap.registry.services.agent.AgentGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author riddy ndoma
 */
@RestController
@RequestMapping("/api/agent-grades")
@RequiredArgsConstructor
public class AgentGradeController {

    private final AgentGradeService agentGradeService;

    @PostMapping
    public ResponseEntity<AgentGrade> createAgentGrade(@RequestBody AgentGrade agentGrade) {
        return ResponseEntity.ok(agentGradeService.saveAgentGrade(agentGrade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentGrade> getAgentGradeById(@PathVariable UUID id) {
        return agentGradeService.findAgentGradeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<AgentGrade>> getAllAgentGrades() {
        return ResponseEntity.ok(agentGradeService.findAllAgentGrades());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentGrade> updateAgentGrade(@PathVariable UUID id, @RequestBody AgentGrade agentGrade) {
        if (!agentGradeService.findAgentGradeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agentGrade.setId(id);
        return ResponseEntity.ok(agentGradeService.updateAgentGrade(agentGrade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgentGrade(@PathVariable UUID id) {
        agentGradeService.deleteAgentGradeById(id);
        return ResponseEntity.noContent().build();
    }
}