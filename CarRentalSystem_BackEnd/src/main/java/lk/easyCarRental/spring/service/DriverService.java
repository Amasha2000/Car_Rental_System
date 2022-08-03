package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.DriverDTO;

import java.util.ArrayList;

public interface DriverService {
    String getLastDid();

    void updateDriverAvailability(String id);

    DriverDTO getDriverById(String id);

    ArrayList<DriverDTO> getAllDrivers();
}
