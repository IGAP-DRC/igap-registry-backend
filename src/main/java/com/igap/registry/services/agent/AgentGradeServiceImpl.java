package com.igap.registry.services.agent;

import com.igap.registry.entities.core.agent.AgentGrade;
import com.igap.registry.repositories.agent.AgentGradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@Service
@RequiredArgsConstructor
public class AgentGradeServiceImpl implements AgentGradeService {

    private final AgentGradeRepository agentGradeRepository;



    @Override
    public AgentGrade saveAgentGrade(AgentGrade agentGrade) {
        return agentGradeRepository.save(agentGrade);
    }

    @Override
    public Optional<AgentGrade> findAgentGradeById(UUID id) {
        return agentGradeRepository.findById(id);
    }

    @Override
    public List<AgentGrade> findAllAgentGrades() {
        return agentGradeRepository.findAll();
    }

    @Override
    public void deleteAgentGradeById(UUID id) {
        agentGradeRepository.deleteById(id);
    }

    @Override
    public AgentGrade updateAgentGrade(AgentGrade agentGrade) {
        return agentGradeRepository.save(agentGrade);
    }
}