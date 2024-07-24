package com.crmSystem.crm_backend.Repository;

import com.crmSystem.crm_backend.Collections.Customer;
import com.crmSystem.crm_backend.DTO.CustomerDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
@RestController
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {
    Optional<Customer> findByPhoneNumber(String phoneNumber);


}

