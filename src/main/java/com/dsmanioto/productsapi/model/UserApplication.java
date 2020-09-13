package com.dsmanioto.productsapi.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserApplication {

    @Id
    private String _id;

    private String username;

    private String password;

    private String name;

    private Boolean admin;

}

