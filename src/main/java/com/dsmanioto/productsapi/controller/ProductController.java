package com.dsmanioto.productsapi.controller;

import com.dsmanioto.productsapi.controller.dto.ProductDTO;
import com.dsmanioto.productsapi.exception.ProductNotFoundException;
import com.dsmanioto.productsapi.model.Product;
import com.dsmanioto.productsapi.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Products")
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @ApiOperation("Find product by id")
    @ApiResponses(value = @ApiResponse(code = 200, message = "OK"))
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String id) {
        Product product = service.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        return ResponseEntity.ok(product);
    }

    @ApiOperation("Find product by name")
    @ApiResponses(value = @ApiResponse(code = 200, message = "OK"))
    @GetMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        Product product = service.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        return ResponseEntity.ok(product);
    }

    @ApiOperation("Orderable - Find products ordeneded by name")
    @ApiResponses(value = @ApiResponse(code = 200, message = "OK"))
    @GetMapping
    public ResponseEntity<List<Product>> findProductsOrdened() {
        List<Product> products = service.findProducts();

        return ResponseEntity.ok(products);
    }

    @ApiOperation("Insert a new product")
    @ApiResponses(value = @ApiResponse(code = 201, message = "CREATED"))
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ProductDTO productDTO) {
        service.save(productDTO.convertoDTOtoObject());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Update a existent product")
    @ApiResponses(value = @ApiResponse(code = 200, message = "OK"))
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProductDTO productDTO) {
        Product product = service.findById(productDTO.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));

        service.save(productDTO.convertoDTOtoObject());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("Delete product by id")
    @ApiResponses(value = @ApiResponse(code = 200, message = "OK"))
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        Product product = service.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));
        service.delete(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
