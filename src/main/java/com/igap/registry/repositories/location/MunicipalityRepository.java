package com.igap.registry.repositories.location;

import com.igap.registry.entities.core.agent.education.LevelEducation;
import com.igap.registry.entities.core.location.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MunicipalityRepository  extends JpaRepository<Municipality, UUID> {
}
