package com.igap.registry.services.core.agent.education;

import com.igap.registry.entities.core.agent.education.AcademicHistory;
import com.igap.registry.repositories.agent.education.AcademicHistoryRepository;
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
public class AcademicHistoryServiceImpl implements AcademicHistoryService {

    private final AcademicHistoryRepository academicHistoryRepository;


    @Override
    public AcademicHistory saveAcademicHistory(AcademicHistory academicHistory) {
        return academicHistoryRepository.save(academicHistory);
    }

    @Override
    public Optional<AcademicHistory> findAcademicHistoryById(UUID id) {
        return academicHistoryRepository.findById(id);
    }

    @Override
    public List<AcademicHistory> findAllAcademicHistories() {
        return academicHistoryRepository.findAll();
    }

    @Override
    public void deleteAcademicHistoryById(UUID id) {
        academicHistoryRepository.deleteById(id);
    }

    @Override
    public AcademicHistory updateAcademicHistory(AcademicHistory academicHistory) {
        return academicHistoryRepository.save(academicHistory);
    }
}