package com.igap.registry.repositories.agent;

import com.igap.registry.entities.core.agent.AgentContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgentContactRepository  extends JpaRepository<AgentContact, UUID> {
}
