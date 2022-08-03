package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.AdminDTO;
import lk.easyCarRental.spring.dto.CustomerDTO;
import lk.easyCarRental.spring.dto.DriverDTO;
import lk.easyCarRental.spring.dto.UserDTO;

public interface UserService {
    void addCustomer(CustomerDTO dto);

    void addAdmin(AdminDTO dto);

    void addDriver(DriverDTO dto);

    UserDTO getUser(String email, String password);

    String getLastUserId();
}
