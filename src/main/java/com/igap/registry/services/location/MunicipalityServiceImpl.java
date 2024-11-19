package com.igap.registry.services.location;

import com.igap.registry.entities.core.location.Municipality;
import com.igap.registry.repositories.location.MunicipalityRepository;
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
public class MunicipalityServiceImpl implements MunicipalityService{
    private final MunicipalityRepository municipalityRepository;

    @Override
    public Municipality saveMunicipality(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }

    @Override
    public Optional<Municipality> getMunicipalityById(UUID id) {
        return municipalityRepository.findById(id);
    }

    @Override
    public List<Municipality> getAllMunicipalities() {
        return municipalityRepository.findAll();
    }

    @Override
    public void deleteMunicipality(UUID id) {
        municipalityRepository.deleteById(id);
    }
}
