package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.CustomerDTO;
import lk.easyCarRental.spring.entity.Customer;
import lk.easyCarRental.spring.repo.CustomerRepo;
import lk.easyCarRental.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if(!customerRepo.existsById(dto.getCustomerId())){
            customerRepo.save(modelMapper.map(dto, Customer.class));
        }else {
            throw new RuntimeException("Customer Already Exists");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(customerRepo.existsById(dto.getCustomerId())){
            customerRepo.save(modelMapper.map(dto,Customer.class));
        }else{
            throw new RuntimeException("No such a customer to update");
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new RuntimeException("No such a customer to delete");
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if(customerRepo.existsById(id)){
            return modelMapper.map(customerRepo.findById(id).get(),CustomerDTO.class);
        }else{
            throw new RuntimeException("No such a customer");
        }
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return modelMapper.map(customerRepo.findAll(),new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }
}
