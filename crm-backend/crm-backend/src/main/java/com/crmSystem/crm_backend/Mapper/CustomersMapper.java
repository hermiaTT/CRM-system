package com.crmSystem.crm_backend.Mapper;

import com.crmSystem.crm_backend.Collections.Customer;
import com.crmSystem.crm_backend.DTO.CustomerDto;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersMapper {
    public static CustomerDto mapToCustomersDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber(),
                customer.getBirthday().getTime(),
                customer.getVipType(),
                customer.getBalance(),
                customer.getComingResource(),
                customer.getFirstLanguage(),
                customer.getNote(),
                customer.getIsVip()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getPhoneNumber(),
                new Timestamp(customerDto.getBirthday()),
                customerDto.getVipType(),
                customerDto.getBalance(),
                customerDto.getComingResource(),
                customerDto.getFirstLanguage(),
                customerDto.getNote(),
                customerDto.getIsVip()
        );
    }

    public static List<CustomerDto> mapToCustomerDtoList(List<Customer> customers){
        return customers.stream().map(CustomersMapper ::mapToCustomersDto)
                .collect(Collectors.toList());
    }
}
