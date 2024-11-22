package com.igap.registry.services.agent;


import com.igap.registry.entities.core.agent.Agent;
import com.igap.registry.repositories.agent.AgentRepository;
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
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    @Override
    public Agent saveAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Optional<Agent> findAgentById(UUID id) {
        return agentRepository.findById(id);
    }

    @Override
    public List<Agent> findAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public void deleteAgentById(UUID id) {
        agentRepository.deleteById(id);
    }

    @Override
    public Agent updateAgent(Agent agent) {
        return agentRepository.save(agent);
    }
}
