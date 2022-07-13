package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.DriverDTO;
import lk.easyCarRental.spring.entity.Driver;
import lk.easyCarRental.spring.repo.DriverRepo;
import lk.easyCarRental.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) {
        if(!driverRepo.existsById(driverDTO.getDriverId())){
            driverRepo.save(modelMapper.map(driverDTO, Driver.class));
        }else{
            throw new RuntimeException("Driver Already Exists");
        }
    }

    @Override
    public void updateDriver(DriverDTO driverDTO) {
        if(driverRepo.existsById(driverDTO.getDriverId())){
            driverRepo.save(modelMapper.map(driverDTO,Driver.class));
        }else {
            throw new RuntimeException("No such a driver to update");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if(driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such a driver to update");
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if(driverRepo.existsById(id)){
            return modelMapper.map(driverRepo.findById(id),DriverDTO.class);
        }else{
            throw new RuntimeException("No such a driver");
        }
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        return modelMapper.map(driverRepo.findAll(),new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }
}
