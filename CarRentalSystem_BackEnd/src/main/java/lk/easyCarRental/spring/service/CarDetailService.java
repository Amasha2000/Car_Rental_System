package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.CarDetailDTO;

public interface CarDetailService {
    String getLastVDID();

    String checkAvailability(String id);

    void deleteVehicle(String id);

    void updateVehicle(CarDetailDTO dto);

    void updateVehicleAvailability(String id, String status);
}
