package com.igap.registry.services.agent;

import com.igap.registry.entities.core.agent.CommissionAffectation;
import com.igap.registry.repositories.agent.CommissionAffectationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommissionAffectationServiceImpl implements CommissionAffectationService {

    private final CommissionAffectationRepository commissionAffectationRepository;


    @Override
    public CommissionAffectation saveCommissionAffectation(CommissionAffectation commissionAffectation) {
        return commissionAffectationRepository.save(commissionAffectation);
    }

    @Override
    public Optional<CommissionAffectation> findCommissionAffectationById(UUID id) {
        return commissionAffectationRepository.findById(id);
    }

    @Override
    public List<CommissionAffectation> findAllCommissionAffectations() {
        return commissionAffectationRepository.findAll();
    }

    @Override
    public void deleteCommissionAffectationById(UUID id) {
        commissionAffectationRepository.deleteById(id);
    }

    @Override
    public CommissionAffectation updateCommissionAffectation(CommissionAffectation commissionAffectation) {
        return commissionAffectationRepository.save(commissionAffectation);
    }
}