package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.CarScheduleDTO;
import lk.easyCarRental.spring.entity.CarSchedule;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.CarScheduleRepo;
import lk.easyCarRental.spring.service.CarScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarScheduleServiceImpl implements CarScheduleService {
    @Autowired
    private CarScheduleRepo vehicleScheduleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addVehicleSchedule(CarScheduleDTO dto) {
        if (!vehicleScheduleRepo.existsById(dto.getVehicle_sdid())) {
            CarSchedule vehicleSchedule = mapper.map(dto, CarSchedule.class);
            vehicleScheduleRepo.save(vehicleSchedule);
        } else {
            throw new ValidationException("Schedule is already in the system!");
        }
    }

    @Override
    public String getLastId() {
        return vehicleScheduleRepo.getLastId();
    }

    @Override
    public ArrayList<CarScheduleDTO> getAll() {
        List<CarSchedule> all = vehicleScheduleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CarScheduleDTO>>() {
        }.getType());
    }

    @Override
    public void updateSchedule(CarScheduleDTO dto) {
        if (vehicleScheduleRepo.existsById(dto.getVehicle_sdid())) {
            CarSchedule vehicleSchedule = mapper.map(dto, CarSchedule.class);
            vehicleScheduleRepo.save(vehicleSchedule);
        } else {
            throw new ValidationException("Cannot find a vehicle!");
        }
    }

    @Override
    public void deleteSchedule(String id) {
        if (vehicleScheduleRepo.existsById(id)) {
            vehicleScheduleRepo.deleteById(id);
        } else {
            throw new ValidationException("Cannot find a vehicle!");
        }
    }
}
