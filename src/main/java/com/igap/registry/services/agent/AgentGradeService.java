package com.igap.registry.services.agent;

import com.igap.registry.entities.core.agent.AgentGrade;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgentGradeService {

    AgentGrade saveAgentGrade(AgentGrade agentGrade);

    Optional<AgentGrade> findAgentGradeById(UUID id);

    List<AgentGrade> findAllAgentGrades();

    void deleteAgentGradeById(UUID id);

    AgentGrade updateAgentGrade(AgentGrade agentGrade);
}