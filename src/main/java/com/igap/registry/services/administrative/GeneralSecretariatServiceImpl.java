package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.GeneralSecretariat;
import com.igap.registry.repositories.administrative.GeneralSecretariatRepository;
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
public class GeneralSecretariatServiceImpl implements GeneralSecretariatService {

    private final GeneralSecretariatRepository generalSecretariatRepository;


    @Override
    public GeneralSecretariat saveGeneralSecretariat(GeneralSecretariat generalSecretariat) {
        return generalSecretariatRepository.save(generalSecretariat);
    }

    @Override
    public Optional<GeneralSecretariat> findGeneralSecretariatById(UUID id) {
        return generalSecretariatRepository.findById(id);
    }

    @Override
    public List<GeneralSecretariat> findAllGeneralSecretariats() {
        return generalSecretariatRepository.findAll();
    }

    @Override
    public void deleteGeneralSecretariatById(UUID id) {
        generalSecretariatRepository.deleteById(id);
    }

    @Override
    public GeneralSecretariat updateGeneralSecretariat(GeneralSecretariat generalSecretariat) {
        return generalSecretariatRepository.save(generalSecretariat);
    }
}
