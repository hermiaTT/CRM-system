package com.crmSystem.crm_backend.Service;

import com.crmSystem.crm_backend.DTO.CustomerDto;
import com.crmSystem.crm_backend.Exception.CustomServiceException;
import com.crmSystem.crm_backend.Exception.DuplicatedDataException;
import com.crmSystem.crm_backend.Exception.ResourcerNotFoundException;
import com.crmSystem.crm_backend.Mapper.CustomersMapper;
import com.crmSystem.crm_backend.Repository.CustomerRepository;
import com.crmSystem.crm_backend.Collections.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Transactional
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomersMapper.mapToCustomer(customerDto);
        try {
            Customer savedCustomer = customerRepository.save(customer);
            return CustomersMapper.mapToCustomersDto(savedCustomer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicatedDataException("Customer already exists");
        } catch (Exception e) {
            throw new CustomServiceException("An unexpected error occurred", e);
        }
    }

    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return CustomersMapper.mapToCustomerDtoList(customers);
    }

    public CustomerDto findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourcerNotFoundException("Customer not exist with the given id: " + id.toString()));
        return CustomersMapper.mapToCustomersDto(customer);
    }

    public CustomerDto findCustomerByPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResourcerNotFoundException("No customer under this phone " + phoneNumber));
        return CustomersMapper.mapToCustomersDto(customer);
    }

    public void deleteCustomerById(Long id) {
        Customer customerToDelete = customerRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException("No customer under this phone " + id.toString()));
        customerRepository.delete(customerToDelete);
    }

    @Transactional
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourcerNotFoundException("No customer under this phone " + id.toString()));

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setBirthday(customerDto.getBirthday());
        customer.setVipType(customerDto.getVipType());
        customer.setBalance(customerDto.getBalance());
        customer.setComingResource(customerDto.getComingResource());
        customer.setFirstLanguage(customerDto.getFirstLanguage());
        customer.setNote(customerDto.getNote());
        customer.setIsVip(customerDto.getIsVip());

        Customer updatedCustomer = customerRepository.save(customer);
        return CustomersMapper.mapToCustomersDto(updatedCustomer);
    }
}
