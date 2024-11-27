package com.igap.registry.services.core.administrative;

import com.igap.registry.entities.core.administrative.Grade;
import com.igap.registry.repositories.administrative.GradeRepository;
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
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;


    @Override
    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Optional<Grade> findGradeById(UUID id) {
        return gradeRepository.findById(id);
    }

    @Override
    public List<Grade> findAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void deleteGradeById(UUID id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public Grade updateGrade(Grade grade) {
        return gradeRepository.save(grade);
    }
}
