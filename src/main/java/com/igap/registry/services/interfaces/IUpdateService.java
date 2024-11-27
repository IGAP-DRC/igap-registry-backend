package com.igap.registry.services.interfaces;


import java.util.UUID;

/**
 * class IUpdateService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IUpdateService<Model> {
    Model update(UUID id, Model model);
}
