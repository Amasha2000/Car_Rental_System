package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.CustomerDTO;
import lk.easyCarRental.spring.entity.Customer;
import lk.easyCarRental.spring.entity.User;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.CustomerRepo;
import lk.easyCarRental.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO getCustomerById(String id) {
        User user = new User();
        user.setUid(id);
        Optional<Customer> c = customerRepo.findByUser(user);
        if (c.isPresent()) {
            Customer customer = c.get();
            return mapper.map(customer, CustomerDTO.class);
        } else {
            throw new ValidationException("There is no any matching Customer in the system!");
        }
    }

    @Override
    public String getLastCid() {
        return customerRepo.geLastCid();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }
}
