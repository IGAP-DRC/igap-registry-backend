package com.igap.registry.services.core.agent.education;

import com.igap.registry.entities.core.agent.education.AcademicProgram;
import com.igap.registry.repositories.agent.education.AcademicProgramRepository;
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
public class AcademicProgramServiceImpl implements AcademicProgramService {

    private final AcademicProgramRepository academicProgramRepository;


    @Override
    public AcademicProgram saveAcademicProgram(AcademicProgram academicProgram) {
        return academicProgramRepository.save(academicProgram);
    }

    @Override
    public Optional<AcademicProgram> findAcademicProgramById(UUID id) {
        return academicProgramRepository.findById(id);
    }

    @Override
    public List<AcademicProgram> findAllAcademicPrograms() {
        return academicProgramRepository.findAll();
    }

    @Override
    public void deleteAcademicProgramById(UUID id) {
        academicProgramRepository.deleteById(id);
    }

    @Override
    public AcademicProgram updateAcademicProgram(AcademicProgram academicProgram) {
        return academicProgramRepository.save(academicProgram);
    }
}