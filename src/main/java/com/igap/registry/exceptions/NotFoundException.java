package com.igap.registry.exceptions;


import java.io.Serial;


/**
 * class NotFoundException
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public class NotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public NotFoundException(String message) {
        super(message);
    }
}
