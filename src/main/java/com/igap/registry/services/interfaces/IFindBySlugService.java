package com.igap.registry.services.interfaces;


/**
 * class IFindBySlugService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IFindBySlugService<Model> {
    Model findBySlug(String slug);
}
