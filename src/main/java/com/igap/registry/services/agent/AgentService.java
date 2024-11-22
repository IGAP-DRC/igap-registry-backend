package com.igap.registry.services.agent;

import com.igap.registry.entities.core.agent.Agent;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgentService {

    Agent saveAgent(Agent agent);

    Optional<Agent> findAgentById(UUID id);

    List<Agent> findAllAgents();

    void deleteAgentById(UUID id);

    Agent updateAgent(Agent agent);
}