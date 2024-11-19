package com.igap.registry.repositories.administrative;

import com.igap.registry.entities.core.administrative.GeneralDirectorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author riddy ndoma
 */
@Repository

public interface GeneralDirectorateRepository extends JpaRepository<GeneralDirectorate, UUID> {

}