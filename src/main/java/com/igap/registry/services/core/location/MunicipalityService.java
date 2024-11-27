package com.igap.registry.services.core.location;

import com.igap.registry.entities.core.location.Municipality;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MunicipalityService {

    Municipality saveMunicipality(Municipality municipality);

    Optional<Municipality> getMunicipalityById(UUID id);

    List<Municipality> getAllMunicipalities();

    void deleteMunicipality(UUID id);
}
