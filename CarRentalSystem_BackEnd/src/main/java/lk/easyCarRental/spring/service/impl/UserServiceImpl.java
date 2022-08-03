package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.AdminDTO;
import lk.easyCarRental.spring.dto.CustomerDTO;
import lk.easyCarRental.spring.dto.DriverDTO;
import lk.easyCarRental.spring.dto.UserDTO;
import lk.easyCarRental.spring.entity.Admin;
import lk.easyCarRental.spring.entity.Customer;
import lk.easyCarRental.spring.entity.Driver;
import lk.easyCarRental.spring.entity.User;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.AdminRepo;
import lk.easyCarRental.spring.repo.CustomerRepo;
import lk.easyCarRental.spring.repo.DriverRepo;
import lk.easyCarRental.spring.repo.UserRepo;
import lk.easyCarRental.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addCustomer(CustomerDTO dto) {
        Optional<Customer> customer = customerRepo.findById(dto.getCustomerId());
        Optional<User> user = userRepo.findById(dto.getUserDTO().getUid());
        if (customer.isPresent() || user.isPresent()) {
            throw new ValidationException("Customer is already registered in the db");
        } else {
            Customer cust = mapper.map(dto, Customer.class);
            customerRepo.save(cust);
        }
    }

    @Override
    public void addAdmin(AdminDTO dto) {
        Optional<Admin> admin = adminRepo.findById(dto.getAdminId());
        Optional<User> user = userRepo.findById(dto.getUser().getUid());
        if (admin.isPresent() || user.isPresent()) {
            throw new ValidationException("Admin is already registered in the db");
        } else {
            Admin a = mapper.map(dto, Admin.class);
            adminRepo.save(a);
        }
    }

    @Override
    public void addDriver(DriverDTO dto) {
        Optional<Driver> driver = driverRepo.findById(dto.getDriverId());
        Optional<User> user = userRepo.findById(dto.getUserDTO().getUid());
        if (driver.isPresent() || user.isPresent()) {
            throw new ValidationException("Driver is already registered in the db");
        } else {
            Driver d = mapper.map(dto, Driver.class);
            driverRepo.save(d);
        }
    }

    @Override
    public UserDTO getUser(String email, String password) {
        /*Optional<User> u = userRepo.findById(id);*/
        Optional<User> u = userRepo.findByEmailAndPassword(email, password);
        if (u.isPresent()) {
            User user = u.get();
            System.out.println(user.toString());
            return mapper.map(user, UserDTO.class);
        }
        return null;
    }

    @Override
    public String getLastUserId() {
        return userRepo.geLastUserId();
    }
}
