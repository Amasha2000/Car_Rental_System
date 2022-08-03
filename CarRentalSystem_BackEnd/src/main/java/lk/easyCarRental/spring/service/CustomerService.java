package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    CustomerDTO getCustomerById(String id);
    String getLastCid();
    ArrayList<CustomerDTO> getAllCustomers();
}
