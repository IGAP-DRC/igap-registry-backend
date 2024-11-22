package com.igap.registry.services.administrative;

import com.igap.registry.entities.core.administrative.Hospital;
import com.igap.registry.repositories.administrative.HospitalRepository;
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
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;


    @Override
    public Hospital saveHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    @Override
    public Optional<Hospital> findHospitalById(UUID id) {
        return hospitalRepository.findById(id);
    }

    @Override
    public List<Hospital> findAllHospitals() {
        return hospitalRepository.findAll();
    }

    @Override
    public void deleteHospitalById(UUID id) {
        hospitalRepository.deleteById(id);
    }

    @Override
    public Hospital updateHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }
}
