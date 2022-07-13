package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    void saveDriver(DriverDTO driverDTO);
    void updateDriver(DriverDTO driverDTO);
    void deleteDriver(String id);
    DriverDTO searchDriver(String id);
    ArrayList<DriverDTO> getAllDrivers();
}
