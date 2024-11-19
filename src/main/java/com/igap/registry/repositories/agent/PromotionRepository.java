package com.igap.registry.repositories.agent;

import com.igap.registry.entities.core.agent.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PromotionRepository extends JpaRepository<Promotion, UUID> {
}
