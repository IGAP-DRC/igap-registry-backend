package com.igap.registry.services.agent;

import com.igap.registry.entities.core.agent.CommissionAffectation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommissionAffectationService {

    CommissionAffectation saveCommissionAffectation(CommissionAffectation commissionAffectation);

    Optional<CommissionAffectation> findCommissionAffectationById(UUID id);

    List<CommissionAffectation> findAllCommissionAffectations();

    void deleteCommissionAffectationById(UUID id);

    CommissionAffectation updateCommissionAffectation(CommissionAffectation commissionAffectation);
}