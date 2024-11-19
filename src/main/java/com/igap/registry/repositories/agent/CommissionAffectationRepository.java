package com.igap.registry.repositories.agent;

import com.igap.registry.entities.core.agent.CommissionAffectation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommissionAffectationRepository extends JpaRepository<CommissionAffectation, UUID> {
}
