package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    CustomerDTO searchCustomer(String id);
    ArrayList<CustomerDTO> getAllCustomers();
}
