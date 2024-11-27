package com.igap.registry.services.interfaces;


/**
 * class IFindByMailService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IFindByMailService<Model> {
    Model findByMail(String mail);
}
