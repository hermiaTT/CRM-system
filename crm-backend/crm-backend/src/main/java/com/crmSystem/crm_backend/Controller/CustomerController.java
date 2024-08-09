package com.crmSystem.crm_backend.Controller;

import com.crmSystem.crm_backend.DTO.CustomerDto;
import com.crmSystem.crm_backend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addNewCustomer(@RequestBody Map<String, CustomerDto> payload) {
        CustomerDto customerDto = payload.get("data");
        if (customerDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return new ResponseEntity<>(customerService.findAllCustomers(),HttpStatus.OK) ;
    }

    @GetMapping("/customer/id/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.findCustomerById(id),HttpStatus.OK) ;
    }

    //form a dynamic querying by key other than object id
    @GetMapping("/customer/phone/{phoneNumber}")
    public ResponseEntity<CustomerDto> getCustomerByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        return  new ResponseEntity<>(customerService.findCustomerByPhoneNumber(phoneNumber),HttpStatus.OK) ;
    }

    //delete customer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer deleted successfully",HttpStatus.OK) ;
    }

    //update customer
    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customerDto), HttpStatus.OK);
    }
}
