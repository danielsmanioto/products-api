package com.dsmanioto.productsapi.handler.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;

}
