package com.igap.registry.repositories.administrative;

import com.igap.registry.entities.core.administrative.GeneralSecretariat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author riddy ndoma
 */
@Repository
public interface GeneralSecretariatRepository extends JpaRepository<GeneralSecretariat, UUID> {
}
