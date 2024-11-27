package com.igap.registry.exceptions;


import com.igap.registry.dto.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


/**
 * class ControllerExceptionHandler
 *
 * @author mecao@main <jbmbiya1@gmail.com>
 * @update  2024 by mecao@main <jbmbiya1@gmail.com>
 * @copyright 2024 AGAP
 */
@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequestException(BadRequestException exception, WebRequest request){
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(NotFoundException exception, WebRequest request){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }


    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorResponse conflictException(ConflictException exception , WebRequest request){
        return  new ErrorResponse(HttpStatus.CONFLICT.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }


    @ExceptionHandler(UnProcessableEntityException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse unProcessableEntityException( UnProcessableEntityException exception, WebRequest request){
        return  new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ErrorResponse unAuthorizedException( BadCredentialsException exception, WebRequest request){
        return  new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequestException(MethodArgumentNotValidException exception, WebRequest request){
        return  new ErrorResponse(HttpStatus.BAD_REQUEST.value(), new Date(), exception.getMessage() + " "+ exception.getCause().getMessage(), request.getDescription(true));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse illegalArgumentException(IllegalArgumentException exception, WebRequest request){
        return  new ErrorResponse(HttpStatus.BAD_REQUEST.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(LockedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ErrorResponse lockedException(LockedException exception, WebRequest request){
        return  new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse globalExceptionHandler(Exception e , WebRequest request){
      return  new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), e.getMessage(), request.getDescription(false));
    }
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorResponse forbiddenException(ForbiddenException exception, WebRequest request){
        return  new ErrorResponse(HttpStatus.FORBIDDEN.value(), new Date(), exception.getMessage(), request.getDescription(false));
    }
}
