package com.igap.registry.services.interfaces;

import java.util.UUID;

/**
 * class IFindByIdService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IFindByIdService<Model> {
    Model findById(UUID id);
}
