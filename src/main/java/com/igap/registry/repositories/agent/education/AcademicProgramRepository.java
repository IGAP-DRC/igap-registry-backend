package com.igap.registry.repositories.agent.education;

import com.igap.registry.entities.core.agent.education.AcademicProgram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author riddy ndoma
 */
public interface AcademicProgramRepository  extends JpaRepository<AcademicProgram, UUID> {
}
