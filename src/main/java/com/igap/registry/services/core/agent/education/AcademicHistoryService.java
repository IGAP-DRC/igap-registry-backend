package com.igap.registry.services.core.agent.education;

import com.igap.registry.entities.core.agent.education.AcademicHistory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AcademicHistoryService {

    AcademicHistory saveAcademicHistory(AcademicHistory academicHistory);

    Optional<AcademicHistory> findAcademicHistoryById(UUID id);

    List<AcademicHistory> findAllAcademicHistories();

    void deleteAcademicHistoryById(UUID id);

    AcademicHistory updateAcademicHistory(AcademicHistory academicHistory);
}
