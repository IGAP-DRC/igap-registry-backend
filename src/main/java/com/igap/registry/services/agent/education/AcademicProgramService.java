package com.igap.registry.services.agent.education;

import com.igap.registry.entities.core.agent.education.AcademicProgram;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AcademicProgramService {

    AcademicProgram saveAcademicProgram(AcademicProgram academicProgram);

    Optional<AcademicProgram> findAcademicProgramById(UUID id);

    List<AcademicProgram> findAllAcademicPrograms();

    void deleteAcademicProgramById(UUID id);

    AcademicProgram updateAcademicProgram(AcademicProgram academicProgram);
}