package com.igap.registry.services.interfaces;
import org.springframework.data.domain.Page;

/**
 * class IFindAllPaginationService
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public interface IFindAllPaginationService<Model>{
     Page<Model> findAllPagination(Integer pageNo, Integer pageSize, String sortBy, String filter);
}
