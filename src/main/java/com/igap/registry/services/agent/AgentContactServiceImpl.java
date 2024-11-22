package com.igap.registry.services.agent;

import com.igap.registry.entities.core.agent.AgentContact;
import com.igap.registry.repositories.agent.AgentContactRepository;
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
public class AgentContactServiceImpl implements AgentContactService {

    private final AgentContactRepository agentContactRepository;



    @Override
    public AgentContact saveAgentContact(AgentContact agentContact) {
        return agentContactRepository.save(agentContact);
    }

    @Override
    public Optional<AgentContact> findAgentContactById(UUID id) {
        return agentContactRepository.findById(id);
    }

    @Override
    public List<AgentContact> findAllAgentContacts() {
        return agentContactRepository.findAll();
    }

    @Override
    public void deleteAgentContactById(UUID id) {
        agentContactRepository.deleteById(id);
    }

    @Override
    public AgentContact updateAgentContact(AgentContact agentContact) {
        return agentContactRepository.save(agentContact);
    }
}
