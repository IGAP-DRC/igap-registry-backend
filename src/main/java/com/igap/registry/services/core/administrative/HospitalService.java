package com.igap.registry.services.core.administrative;

import com.igap.registry.entities.core.administrative.Hospital;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HospitalService {

    Hospital saveHospital(Hospital hospital);

    Optional<Hospital> findHospitalById(UUID id);

    List<Hospital> findAllHospitals();

    void deleteHospitalById(UUID id);

    Hospital updateHospital(Hospital hospital);
}