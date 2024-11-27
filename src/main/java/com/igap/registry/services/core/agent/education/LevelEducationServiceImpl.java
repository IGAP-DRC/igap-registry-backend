package com.igap.registry.services.core.agent.education;

import com.igap.registry.entities.core.agent.education.LevelEducation;
import com.igap.registry.repositories.agent.education.LevelEducationRepository;
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
public class LevelEducationServiceImpl implements LevelEducationService {

    private final LevelEducationRepository levelEducationRepository;

    @Override
    public LevelEducation saveLevelEducation(LevelEducation levelEducation) {
        return levelEducationRepository.save(levelEducation);
    }

    @Override
    public Optional<LevelEducation> findLevelEducationById(UUID id) {
        return levelEducationRepository.findById(id);
    }

    @Override
    public List<LevelEducation> findAllLevelEducations() {
        return levelEducationRepository.findAll();
    }

    @Override
    public void deleteLevelEducationById(UUID id) {
        levelEducationRepository.deleteById(id);
    }

    @Override
    public LevelEducation updateLevelEducation(LevelEducation levelEducation) {
        return levelEducationRepository.save(levelEducation);
    }
}