package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.GeneralDirectorate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GeneralDirectorateService {

    GeneralDirectorate saveGeneralDirectorate(GeneralDirectorate generalDirectorate);

    Optional<GeneralDirectorate> findGeneralDirectorateById(UUID id);

    List<GeneralDirectorate> findAllGeneralDirectorates();

    void deleteGeneralDirectorateById(UUID id);

    GeneralDirectorate updateGeneralDirectorate(GeneralDirectorate generalDirectorate);
}