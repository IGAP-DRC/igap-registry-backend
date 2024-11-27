package com.igap.registry.services.core.agent;

import com.igap.registry.entities.core.agent.AgentContact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AgentContactService {

    AgentContact saveAgentContact(AgentContact agentContact);

    Optional<AgentContact> findAgentContactById(UUID id);

    List<AgentContact> findAllAgentContacts();

    void deleteAgentContactById(UUID id);

    AgentContact updateAgentContact(AgentContact agentContact);
}