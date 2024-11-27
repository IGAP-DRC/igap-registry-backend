package com.igap.registry.services.core.administrative;

import com.igap.registry.entities.core.administrative.Directorate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DirectorateService {
    Directorate saveDirectorate(Directorate directorate);

    Optional<Directorate> findDirectorateById(UUID id);

    List<Directorate> findAllDirectorates();

    void deleteDirectorateById(UUID id);

    Directorate updateDirectorate(Directorate directorate);
}
