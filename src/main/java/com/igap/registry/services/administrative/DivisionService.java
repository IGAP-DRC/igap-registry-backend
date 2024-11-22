package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Division;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DivisionService {

    Division saveDivision(Division division);

    Optional<Division> findDivisionById(UUID id);

    List<Division> findAllDivisions();

    void deleteDivisionById(UUID id);

    Division updateDivision(Division division);
}