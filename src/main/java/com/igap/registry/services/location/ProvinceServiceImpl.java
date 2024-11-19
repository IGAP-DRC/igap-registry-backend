package com.igap.registry.services.location;

import com.igap.registry.entities.core.location.Province;
import com.igap.registry.repositories.location.ProvinceRepository;
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
public class ProvinceServiceImpl implements ProvinceService{

    private final ProvinceRepository provinceRepository;


    @Override
    public Province saveProvince(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public Optional<Province> getProvinceById(UUID id) {
        return provinceRepository.findById(id);
    }

    @Override
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    public void deleteProvince(UUID id) {
        provinceRepository.deleteById(id);
    }
}
