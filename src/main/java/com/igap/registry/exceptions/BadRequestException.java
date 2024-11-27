package com.igap.registry.exceptions;
import java.io.Serial;


/**
 * class BadRequestException
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public class BadRequestException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;
    public BadRequestException(String message) {
        super(message);
    }
}
