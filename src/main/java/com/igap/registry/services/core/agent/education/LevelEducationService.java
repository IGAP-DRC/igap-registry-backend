package com.igap.registry.services.core.agent.education;

import com.igap.registry.entities.core.agent.education.LevelEducation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LevelEducationService {

    LevelEducation saveLevelEducation(LevelEducation levelEducation);

    Optional<LevelEducation> findLevelEducationById(UUID id);

    List<LevelEducation> findAllLevelEducations();

    void deleteLevelEducationById(UUID id);

    LevelEducation updateLevelEducation(LevelEducation levelEducation);
}