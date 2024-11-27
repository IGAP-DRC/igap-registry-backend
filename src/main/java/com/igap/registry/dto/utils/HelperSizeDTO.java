package com.igap.registry.dto.utils;


import lombok.Getter;
import lombok.Setter;

/**
 * class HelperResponseDTO
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
public class HelperSizeDTO {

    private String name;
    private Integer size;
    private Double percentage;

    public HelperSizeDTO(String name, Integer size) {
        this.name = name;
        this.size = size;
        this.percentage = 0.0;
    }
}
