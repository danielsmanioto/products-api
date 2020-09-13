package com.dsmanioto.productsapi.controller;

import com.dsmanioto.productsapi.controller.dto.UserApplicationDTO;
import com.dsmanioto.productsapi.exception.ProductNotFoundException;
import com.dsmanioto.productsapi.model.Product;
import com.dsmanioto.productsapi.model.UserApplication;
import com.dsmanioto.productsapi.service.UserApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "User Application")
@RestController
@RequestMapping("/user-application/mannager")
public class UserApplicationController {

    private final UserApplicationService service;

    @Autowired
    public UserApplicationController(UserApplicationService service) {
        this.service = service;
    }

    @ApiOperation("Insert a new user")
    @ApiResponses(value = @ApiResponse(code = 201, message = "CREATED"))
    @PostMapping("/new-user")
    public ResponseEntity<?> insert(@Valid @RequestBody UserApplicationDTO userApplicationDTO) {
        service.save(userApplicationDTO.convertDTOtoObject());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Find all users")
    @ApiResponses(value = @ApiResponse(code = 200, message = "OK"))
    @GetMapping("/sysadmin")
    public List<UserApplication> findAllUsers() {
        return service.findAll();
    }

    @ApiOperation("Reset users password")
    @ApiResponses(value = @ApiResponse(code = 200, message = "OK"))
    @PutMapping("/sysadmin/{username}")
    public ResponseEntity<?> resetUserPassword(@PathVariable String username) {
        UserApplication userApplication = service.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));

        service.resetPasswordByUsername(userApplication);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
