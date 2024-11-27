package com.igap.registry.services.core.location;

import com.igap.registry.entities.core.location.Province;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProvinceService {
    Province saveProvince(Province province);

    Optional<Province> getProvinceById(UUID id);

    List<Province> getAllProvinces();

    void deleteProvince(UUID id);
}
