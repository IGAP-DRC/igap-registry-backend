package com.igap.registry.repositories.agent;

import com.igap.registry.entities.core.agent.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
/**
 * @author ri com.igap.registry.repositories.agent;
ddy ndoma
 */
public interface AgentRepository  extends JpaRepository<Agent, UUID> {
}
