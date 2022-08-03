package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.CarScheduleDTO;

import java.util.ArrayList;

public interface CarScheduleService {
    void addVehicleSchedule(CarScheduleDTO dto);

    String getLastId();

    ArrayList<CarScheduleDTO> getAll();

    void updateSchedule(CarScheduleDTO dto);

    void deleteSchedule(String id);
}
