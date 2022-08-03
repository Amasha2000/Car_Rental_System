package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.DriverDTO;
import lk.easyCarRental.spring.entity.Driver;
import lk.easyCarRental.spring.entity.User;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.DriverRepo;
import lk.easyCarRental.spring.service.DriverService;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public ArrayList<DriverDTO> getAllDrivers() {
        User user = new User();
        user.setUid("000");
        List<Driver> all = driverRepo.findAllByUserNotLike(user);
        return mapper.map(all, new TypeToken<ArrayList<DriverDTO>>() {
        }.getType());
    }

    @Override
    public String getLastDid() {
        return driverRepo.geLastDid();
    }

    @Override
    public void updateDriverAvailability(String id) {
        Optional<Driver> d = driverRepo.findById(id);
        if (d.isPresent()) {
            Driver driver = d.get();
            driver.setAvailability("Unavailable");
        } else {
            throw new ValidationException("There is no any matching Driver in the system!");
        }
    }

    @Override
    public DriverDTO getDriverById(String id) {
        User user = new User();
        user.setUid(id);
        Optional<Driver> d = driverRepo.findByUser(user);
        if (d.isPresent()) {
            Driver driver = d.get();
            return mapper.map(driver, DriverDTO.class);
        } else {
            throw new ValidationException("There is no any matching Driver in the system!");
        }
    }
}
