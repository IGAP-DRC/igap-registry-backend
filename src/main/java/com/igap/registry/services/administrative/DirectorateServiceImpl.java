package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Directorate;
import com.igap.registry.repositories.administrative.DirectorateRepository;
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
public class DirectorateServiceImpl implements DirectorateService {

    private final DirectorateRepository directorateRepository;


    @Override
    public Directorate saveDirectorate(Directorate directorate) {
        return directorateRepository.save(directorate);
    }

    @Override
    public Optional<Directorate> findDirectorateById(UUID id) {
        return directorateRepository.findById(id);
    }

    @Override
    public List<Directorate> findAllDirectorates() {
        return directorateRepository.findAll();
    }

    @Override
    public void deleteDirectorateById(UUID id) {
        directorateRepository.deleteById(id);
    }

    @Override
    public Directorate updateDirectorate(Directorate directorate) {
        return directorateRepository.save(directorate);
    }
}
