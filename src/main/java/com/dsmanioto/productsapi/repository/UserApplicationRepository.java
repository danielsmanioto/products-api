package com.dsmanioto.productsapi.repository;

import com.dsmanioto.productsapi.model.UserApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserApplicationRepository extends MongoRepository<UserApplication, String> {

    Optional<UserApplication> findByUsername(String username);

}
