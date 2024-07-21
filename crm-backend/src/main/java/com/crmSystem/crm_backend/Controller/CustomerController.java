package com.crmSystem.crm_backend.Controller;

import com.crmSystem.crm_backend.Service.CustomerService;
import com.crmSystem.crm_backend.DataCollection.Customers;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
        return new ResponseEntity<List<Customers>>(customerService.allCustomers(),HttpStatus.OK) ;
    }

    //get single movie
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customers>> getCustomerById(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Customers>>(customerService.findCustomerById(id),HttpStatus.OK) ;
    }

    //form a dynamic querying by key other than object id
    @GetMapping("/customer/{phoneNumber}")
    public ResponseEntity<Optional<Customers>> getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        return  new ResponseEntity<Optional<Customers>>(customerService.findCustomerByPhoneNumber(phoneNumber),HttpStatus.OK) ;
    }
}
