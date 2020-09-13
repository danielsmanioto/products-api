package com.dsmanioto.productsapi.service;


import com.dsmanioto.productsapi.model.UserApplication;
import com.dsmanioto.productsapi.repository.UserApplicationRepository;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataMongo
public class UserApplicationServiceTest {

    @InjectMocks
    private UserApplicationService service;

    @Mock
    private UserApplicationRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validateFindByUserName() {
        BDDMockito.given(repository.findByUsername("daniel"))
                .willReturn(Optional.ofNullable(getUserApplicationMock()));

        Optional<UserApplication> userApplication = service.findByUserName("daniel");

        Assertions.assertEquals("Daniel Smanioto",  userApplication.get().getName());
        Assertions.assertEquals("daniel",  userApplication.get().getUsername());
        Assertions.assertEquals("123456",  userApplication.get().getPassword());
    }

    private UserApplication getUserApplicationMock() {
        return UserApplication.builder()
                .username("daniel")
                .password("123456")
                .name("Daniel Smanioto")
                .admin(true)
                .build();
    }

    @Test
    public void validateSave() {
        service.save(getUserApplicationMock());
    }

}
