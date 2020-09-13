package com.dsmanioto.productsapi.controller;

import com.dsmanioto.productsapi.model.Product;
import com.dsmanioto.productsapi.service.ProductService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    /*private static final String CONTENT_TYPE = "application/json;charset=UTF8";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findById() throws Exception {
        Product productMock = Product.builder()
                .id("5f597d3ca003400cce62fe91")
                .name("Corona")
                .description("Mexican beer")
                .brand("Corona")
                .price(new BigDecimal("4.39"))
                .build();

        BDDMockito.given(productService.findById("5f597d3ca003400cce62fe91"))
                .willReturn(Optional.ofNullable(productMock));


        mockMvc.perform(get("/v1/protected/products/5f597d3ca003400cce62fe91").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Corona"));
    }

    @Test
    public void findAllOrdenedByName() throws Exception {
        Product productMock1 = Product.builder()
                .id("5f597d3ca003400cce62fe91")
                .name("Corona")
                .description("Mexican beer")
                .brand("Corona")
                .price(new BigDecimal("4.39"))
                .build();
        Product productMock2 = Product.builder()
                .id("34234234sadasd2131")
                .name("Stella")
                .description("Beer")
                .brand("Stella")
                .price(new BigDecimal("3.89"))
                .build();
        List<Product> productsMocks = Arrays.asList(productMock1, productMock2);
        BDDMockito.given(productService.findProducts()).willReturn(productsMocks);

        mockMvc.perform(get("/v1/protected/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].name").value("Corona"))
                .andExpect(jsonPath("$.[1].name").value("Stella"));
    }*/


}
