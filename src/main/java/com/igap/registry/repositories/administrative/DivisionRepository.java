package com.igap.registry.repositories.administrative;

/**
 * @author riddy ndoma
 */

import com.igap.registry.entities.core.administrative.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DivisionRepository extends JpaRepository<Division, UUID> {
}