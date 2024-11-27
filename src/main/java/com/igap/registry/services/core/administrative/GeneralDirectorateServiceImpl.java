package com.igap.registry.services.core.administrative;

import com.igap.registry.entities.core.administrative.GeneralDirectorate;
import com.igap.registry.repositories.administrative.GeneralDirectorateRepository;
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
public class GeneralDirectorateServiceImpl implements GeneralDirectorateService {

    private final GeneralDirectorateRepository generalDirectorateRepository;


    @Override
    public GeneralDirectorate saveGeneralDirectorate(GeneralDirectorate generalDirectorate) {
        return generalDirectorateRepository.save(generalDirectorate);
    }

    @Override
    public Optional<GeneralDirectorate> findGeneralDirectorateById(UUID id) {
        return generalDirectorateRepository.findById(id);
    }

    @Override
    public List<GeneralDirectorate> findAllGeneralDirectorates() {
        return generalDirectorateRepository.findAll();
    }

    @Override
    public void deleteGeneralDirectorateById(UUID id) {
        generalDirectorateRepository.deleteById(id);
    }

    @Override
    public GeneralDirectorate updateGeneralDirectorate(GeneralDirectorate generalDirectorate) {
        return generalDirectorateRepository.save(generalDirectorate);
    }
}