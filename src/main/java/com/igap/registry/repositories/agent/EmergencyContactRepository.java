package com.igap.registry.repositories.agent;

import com.igap.registry.entities.core.agent.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, UUID> {
}
