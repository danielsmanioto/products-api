package com.dsmanioto.productsapi.controller.dto;

import com.dsmanioto.productsapi.model.Product;
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

    public Product convertoDTOtoObject() {
        return Product.builder()
                ._id(this.id)
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .build();
    }

}
