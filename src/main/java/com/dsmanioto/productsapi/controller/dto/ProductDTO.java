package com.dsmanioto.productsapi.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductDTO {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;

}
