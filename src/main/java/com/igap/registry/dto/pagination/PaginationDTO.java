package com.igap.registry.dto.pagination;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * class PaginationDTO
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
public class PaginationDTO {
    private int pageSize;
    private int currentPage;
    private long totalItems;
    private List<?> data;

    public PaginationDTO(int pageSize, int currentPage, long totalItems, List<?> data) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.data = data;
    }
}
