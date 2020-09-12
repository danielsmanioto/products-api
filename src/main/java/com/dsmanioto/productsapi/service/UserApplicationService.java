package com.dsmanioto.productsapi.service;

import com.dsmanioto.productsapi.model.UserApplication;
import com.dsmanioto.productsapi.repository.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApplicationService {

    private final UserApplicationRepository repository;

    @Autowired
    public UserApplicationService(UserApplicationRepository repository) {
        this.repository = repository;
    }

    public void save(UserApplication userApplication) {
        String passwordEncripted = new BCryptPasswordEncoder().encode(userApplication.getPassword());
        userApplication.setPassword(passwordEncripted);
        repository.save(userApplication);
    }

    public Optional<UserApplication> findByUserName(String username) {
        return repository.findById(username);
    }

}
