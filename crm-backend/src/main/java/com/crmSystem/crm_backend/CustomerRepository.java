package com.crmSystem.crm_backend;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
@RestController
public interface CustomerRepository extends MongoRepository<Customers, ObjectId> {
    Optional<Customers> findByPhoneNumber(String phoneNumber);


}

