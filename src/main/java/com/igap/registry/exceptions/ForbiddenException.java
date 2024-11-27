package com.igap.registry.exceptions;

import java.io.Serial;

/**
 * class ForbiddenException
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public class ForbiddenException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public ForbiddenException(String message) {
        super(message);
    }
}
