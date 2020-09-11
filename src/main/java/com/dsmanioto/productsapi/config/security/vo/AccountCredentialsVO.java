package com.dsmanioto.productsapi.config.security.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AccountCredentialsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

}
