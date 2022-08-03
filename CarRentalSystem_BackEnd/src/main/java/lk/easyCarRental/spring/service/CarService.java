package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.CarDTO;

import java.util.ArrayList;

public interface CarService {
    void saveCar(CarDTO carDTO);
    void updateCar(CarDTO carDTO);
    void deleteCarCategory(String id);
    CarDTO searchCar(String id);
    ArrayList<CarDTO> getAllCars();

    ArrayList<CarDTO> findAllAvailableVehicles();
    String getLastVid();
}
