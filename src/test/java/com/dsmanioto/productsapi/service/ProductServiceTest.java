package com.dsmanioto.productsapi.service;

import com.dsmanioto.productsapi.controller.dto.ProductDTO;
import com.dsmanioto.productsapi.model.Product;
import com.dsmanioto.productsapi.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findById() {
        Product productMock = setProductMock("5f597d3ca003400cce62fe91", "Corona", "Mexican beer", "4.39");

        BDDMockito.given(productService.findById("5f597d3ca003400cce62fe91"))
                .willReturn(Optional.ofNullable(productMock));

        Optional<Product> product = productService.findById("5f597d3ca003400cce62fe91");
        Assertions.assertEquals("Corona", productMock.getName());
        Assertions.assertEquals("5f597d3ca003400cce62fe91", productMock.getId());
        Assertions.assertEquals(new BigDecimal("4.39"), productMock.getPrice());
        Assertions.assertEquals(new BigDecimal("4.39"), productMock.getPrice());
        Assertions.assertEquals("Corona", productMock.getBrand());
    }

    @Test
    public void findByName() {
        Product productMock = setProductMock("5f597d3ca003400cce62fe91", "Corona", "Mexican beer", "4.39");

        BDDMockito.given(productService.findByName("Corona"))
                .willReturn(Optional.ofNullable(productMock));

        Optional<Product> product = productService.findById("5f597d3ca003400cce62fe91");
        Assertions.assertEquals("Corona", productMock.getName());
    }

    @Test
    public void findProducts() {
        BDDMockito.given(productService.findProducts())
                .willReturn(productsOrdenedMock());

        List<Product> products = productService.findProducts();
        Assertions.assertEquals("Corona", products.get(0).getName());
        Assertions.assertEquals("Stella", products.get(1).getName());

    }

    private List<Product> productsOrdenedMock() {
        Product productMock1 = setProductMock("34234234sadasd2131", "Stella", "Beer", "3.89");
        Product productMock2 = setProductMock("5f597d3ca003400cce62fe91", "Corona", "Mexican beer", "4.39");
        return Arrays.asList(productMock1, productMock2);
    }

    @Test
    public void saveProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Corona");
        productDTO.setDescription("Corona");
        productDTO.setPrice(new BigDecimal("4.38"));

        productService.save(productDTO);
    }

    @Test
    public void deleteProduct() {
        Product product = setProductMock("5f597d3ca003400cce62fe91", "Corona", "Mexican beer", "4.39");

        productService.delete(product);
    }

    private Product setProductMock(String s, String stella, String beer, String s2) {
        return Product.builder()
                .id(s)
                .name(stella)
                .description(beer)
                .brand(stella)
                .price(new BigDecimal(s2))
                .build();
    }

}
