package com.dsmanioto.productsapi.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.math.BigDecimal;

@Document
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Product {

    @Id
    private String _id;

    private String name;

    private String description;

    private BigDecimal price;

    private String brand;

}
