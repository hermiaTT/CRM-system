package com.crmSystem.crm_backend.Service;


import com.crmSystem.crm_backend.Repository.CustomerRepository;
import com.crmSystem.crm_backend.DataCollection.Customers;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//database access method
@Service
public class CustomerService {
    //autowired to instantiate the class
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customers> allCustomers(){
        return customerRepository.findAll();
    }

    //it may return null, so need an optional header
    public Optional<Customers> findCustomerById(ObjectId id){
        return customerRepository.findById(id);
    }
    public Optional<Customers> findCustomerByPhoneNumber(String phoneNumber){
        return customerRepository.findByPhoneNumber(phoneNumber);
    }
}
