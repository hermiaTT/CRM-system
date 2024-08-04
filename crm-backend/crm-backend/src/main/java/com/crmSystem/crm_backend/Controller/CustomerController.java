package com.crmSystem.crm_backend.Controller;

import com.crmSystem.crm_backend.DTO.CustomerDto;
import com.crmSystem.crm_backend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> addNewCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<CustomerDto>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<List<CustomerDto>>(customerService.findAllCustomers(),HttpStatus.OK) ;
    }

    @GetMapping("/customer/id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id) {
        return new ResponseEntity<CustomerDto>(customerService.findCustomerById(id),HttpStatus.OK) ;
    }

    //form a dynamic querying by key other than object id
    @GetMapping("/customer/phone/{phoneNumber}")
    public ResponseEntity<CustomerDto> getCustomerByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return  new ResponseEntity<CustomerDto>(customerService.findCustomerByPhoneNumber(phoneNumber),HttpStatus.OK) ;
    }

    //delete customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<String>("Customer deleted successfully",HttpStatus.OK) ;
    }

    //update customer
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<CustomerDto>(customerService.updateCustomer(id, customerDto), HttpStatus.OK);
    }
}
