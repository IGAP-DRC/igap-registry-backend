package com.igap.registry.services.interfaces;

/**
 * class IIsExistService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IIsExistService<Model>{
    Boolean isExist(Model model);
}
