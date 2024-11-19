package com.igap.registry.repositories.agent;

import com.igap.registry.entities.core.agent.AgentGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgentGradeRepository extends JpaRepository<AgentGrade, UUID> {
}
