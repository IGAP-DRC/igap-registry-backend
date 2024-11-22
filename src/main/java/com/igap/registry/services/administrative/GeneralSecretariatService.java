package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.GeneralSecretariat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GeneralSecretariatService {

    GeneralSecretariat saveGeneralSecretariat(GeneralSecretariat generalSecretariat);

    Optional<GeneralSecretariat> findGeneralSecretariatById(UUID id);

    List<GeneralSecretariat> findAllGeneralSecretariats();

    void deleteGeneralSecretariatById(UUID id);

    GeneralSecretariat updateGeneralSecretariat(GeneralSecretariat generalSecretariat);
}