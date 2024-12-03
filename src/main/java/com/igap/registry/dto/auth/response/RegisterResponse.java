package com.igap.registry.dto.auth.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Joe Monkila
 */

 @Getter
 @Setter
 public class RegisterResponse<T> {
     private int status;
     private String message;
     private Object data;
 }