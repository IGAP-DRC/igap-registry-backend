package com.igap.registry.repositories.agent.education;

import com.igap.registry.entities.core.agent.education.LevelEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LevelEducationRepository extends JpaRepository<LevelEducation, UUID> {
}
