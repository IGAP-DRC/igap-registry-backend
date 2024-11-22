package com.igap.registry.services.agent;

import com.igap.registry.entities.core.agent.Promotion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
public interface PromotionService {

    Promotion savePromotion(Promotion promotion);

    Optional<Promotion> findPromotionById(UUID id);

    List<Promotion> findAllPromotions();

    void deletePromotionById(UUID id);

    Promotion updatePromotion(Promotion promotion);
}