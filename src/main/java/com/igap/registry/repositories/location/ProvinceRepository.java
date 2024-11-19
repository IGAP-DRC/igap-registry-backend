package com.igap.registry.repositories.location;

import com.igap.registry.entities.core.location.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProvinceRepository  extends JpaRepository<Province, UUID> {
}
