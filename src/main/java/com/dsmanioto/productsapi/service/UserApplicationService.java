package com.dsmanioto.productsapi.service;

import com.dsmanioto.productsapi.autentication.PasswordEncrypter;
import com.dsmanioto.productsapi.exception.UserAlreadyExistException;
import com.dsmanioto.productsapi.model.UserApplication;
import com.dsmanioto.productsapi.repository.UserApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserApplicationService {

    public static final String DEFAULT_PASSWORD = "change-me";
    private final UserApplicationRepository repository;

    @Autowired
    public UserApplicationService(UserApplicationRepository repository) {
        this.repository = repository;
    }

    public void save(UserApplication userApplication) {
        validateUserExist(userApplication);

        userApplication.setPassword(PasswordEncrypter.encrypt(userApplication.getPassword()));
        repository.save(userApplication);
    }

    private void validateUserExist(UserApplication userApplication) {
        Optional<UserApplication> user = repository.findByUsername(userApplication.getUsername());
        if(user.isPresent()) {
            throw new UserAlreadyExistException("User " + user.get().getUsername() + " already exist.");
        }
    }

    public Optional<UserApplication> findByUserName(String username) {
        return repository.findByUsername(username);
    }

    public List<UserApplication> findAll() {
        return repository.findAll();
    }

    public void resetPasswordByUsername(UserApplication userApplication) {
        userApplication.setPassword(PasswordEncrypter.encrypt(DEFAULT_PASSWORD));
        repository.save(userApplication);
    }

}
