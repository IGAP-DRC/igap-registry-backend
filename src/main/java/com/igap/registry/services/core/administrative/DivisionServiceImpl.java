package com.igap.registry.services.core.administrative;

import com.igap.registry.entities.core.administrative.Division;
import com.igap.registry.repositories.administrative.DivisionRepository;
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
public class DivisionServiceImpl implements DivisionService {

    private final DivisionRepository divisionRepository;


    @Override
    public Division saveDivision(Division division) {
        return divisionRepository.save(division);
    }

    @Override
    public Optional<Division> findDivisionById(UUID id) {
        return divisionRepository.findById(id);
    }

    @Override
    public List<Division> findAllDivisions() {
        return divisionRepository.findAll();
    }

    @Override
    public void deleteDivisionById(UUID id) {
        divisionRepository.deleteById(id);
    }

    @Override
    public Division updateDivision(Division division) {
        return divisionRepository.save(division);
    }
}