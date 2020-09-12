package com.dsmanioto.productsapi.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Document
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserApplication {

    @Column(unique = true)
    //@NotEmpty
    private String username;

    //@NotEmpty
    private String password;

    //@NotEmpty
    private String name;

}
