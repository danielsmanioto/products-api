package com.dsmanioto.productsapi.controller.dto;

import com.dsmanioto.productsapi.model.UserApplication;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserApplicationDTO {

    @NotBlank
    @NotEmpty
    private String username;

    @NotBlank
    @NotEmpty
    private String password;

    @NotBlank
    @NotEmpty
    private String name;

    public UserApplication convertDTOtoObject() {
        return UserApplication.builder()
                .username(this.username)
                .password(this.password)
                .name(this.name).build();
    }

}
