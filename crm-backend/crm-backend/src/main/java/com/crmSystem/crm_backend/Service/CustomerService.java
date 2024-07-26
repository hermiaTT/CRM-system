package com.crmSystem.crm_backend.Service;


import com.crmSystem.crm_backend.DTO.CustomerDto;
import com.crmSystem.crm_backend.Exception.ResourcerNotFoundException;
import com.crmSystem.crm_backend.Mapper.CustomersMapper;
import com.crmSystem.crm_backend.Repository.CustomerRepository;
import com.crmSystem.crm_backend.Collections.Customer;
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

    public List<CustomerDto> allCustomers(){
        List<Customer> customers = customerRepository.findAll();
        return CustomersMapper.mapToCustomerDtoList(customers);
    }

    //it may return null, so need an optional header
    public CustomerDto findCustomerById(ObjectId id){
        Customer customer =  customerRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException(id.toString()));
        return CustomersMapper.mapToCustomersDto(customer);
    }

    public CustomerDto findCustomerByPhoneNumber(String phoneNumber){
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourcerNotFoundException("no customer under this phone"+ phoneNumber));

        return CustomersMapper.mapToCustomersDto(customer) ;
    }

    //delete customer
    public void deleteCustomerById(ObjectId id){
        Customer customerToDelete = customerRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException(id.toString()));
        customerRepository.delete(customerToDelete);
    }
}
