package com.crmSystem.crm_backend.Controller;

import com.crmSystem.crm_backend.DTO.CustomerDto;
import com.crmSystem.crm_backend.Service.CustomerService;
import com.crmSystem.crm_backend.Collections.Customer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<List<CustomerDto>>(customerService.allCustomers(),HttpStatus.OK) ;
    }

    //get single movie
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable ObjectId id) {
        return new ResponseEntity<CustomerDto>(customerService.findCustomerById(id),HttpStatus.OK) ;
    }

    //form a dynamic querying by key other than object id
    @GetMapping("/customer/{phoneNumber}")
    public ResponseEntity<CustomerDto> getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        return  new ResponseEntity<CustomerDto>(customerService.findCustomerByPhoneNumber(phoneNumber),HttpStatus.OK) ;
    }

    //delete customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable ObjectId id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<String>("customer deleted",HttpStatus.OK) ;
    }
}
