package com.igap.registry.services.interfaces;

import java.util.List;

/**
 * class IAddAllService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IAddAllService<Model>{
    void saveAll(List<Model> list);
}
