package com.dsmanioto.productsapi.service;

import com.dsmanioto.productsapi.controller.dto.ProductDTO;
import com.dsmanioto.productsapi.exception.ProductAlreadyExistException;
import com.dsmanioto.productsapi.model.Product;
import com.dsmanioto.productsapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(ProductDTO productDTO) {
        validateProduct(productDTO);

        Product product = Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .brand(productDTO.getBrand())
                .build();

        repository.save(product);
    }

    private void validateProduct(ProductDTO productDTO) {
        Optional<Product> product = repository.findByName(productDTO.getName());
        if (product.isPresent()) {
            throw new ProductAlreadyExistException("Product already exist.");
        }
    }

    public Optional<Product> findById(String id) {
        return repository.findById(id);
    }

    public Optional<Product> findByName(String name) {
        return repository.findByName(name);
    }

    public void delete(Product product) {
        repository.delete(product);
    }

    public List<Product> findProducts() {
        List<Product> products = repository.findAll();
        products.sort(Comparator.comparing(Product::getName));
        return products;
    }

}

