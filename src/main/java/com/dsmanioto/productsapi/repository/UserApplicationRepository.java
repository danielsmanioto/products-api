package com.dsmanioto.productsapi.repository;

import com.dsmanioto.productsapi.model.UserApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserApplicationRepository extends MongoRepository<UserApplication, String> {
}
