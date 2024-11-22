package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Grade;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GradeService {

    Grade saveGrade(Grade grade);

    Optional<Grade> findGradeById(UUID id);

    List<Grade> findAllGrades();

    void deleteGradeById(UUID id);

    Grade updateGrade(Grade grade);
}