package com.igap.registry.exceptions;

import org.springframework.security.authentication.BadCredentialsException;


/**
 * class CustomBadCredentialsException
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
public class CustomBadCredentialsException extends BadCredentialsException {
    public CustomBadCredentialsException(String message) {
        super(message);
    }
    public CustomBadCredentialsException(String message, Throwable t) {
        super(message, t);
    }
}
