package com.igap.registry.dto.utils;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * class HelperNameDTO
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@Getter
@Setter
public class HelperNameDTO {
    @NotBlank
    @Schema(type = "string", title = "name",description = "the name.", example="Name", defaultValue = "Name")
    private String name;
}
