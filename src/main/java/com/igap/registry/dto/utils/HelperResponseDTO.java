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
public class HelperResponseDTO {

    private String message;
    private Integer code;


    public HelperResponseDTO(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
