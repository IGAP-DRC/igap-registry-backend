package com.igap.registry.services.core.administrative;

import com.igap.registry.entities.core.administrative.Service;
import com.igap.registry.repositories.administrative.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author riddy ndoma
 */
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;


    @Override
    public Service saveService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Optional<Service> findServiceById(UUID id) {
        return serviceRepository.findById(id);
    }

    @Override
    public List<Service> findAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public void deleteServiceById(UUID id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Service updateService(Service service) {
        return serviceRepository.save(service);
    }
}
