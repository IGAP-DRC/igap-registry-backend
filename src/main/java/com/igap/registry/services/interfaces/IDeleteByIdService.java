package com.igap.registry.services.interfaces;

import org.springframework.lang.NonNull;

import java.util.UUID;

/**
 * class IDeleteByIdService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IDeleteByIdService<Model> {
    Model deleteByIdAndReason(@NonNull UUID id, @NonNull String reason);
}
