package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.CarDTO;
import lk.easyCarRental.spring.entity.Car;
import lk.easyCarRental.spring.entity.CarDetail;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.CarRepo;
import lk.easyCarRental.spring.service.CarService;
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
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo vehicleRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        /*if (vehicleRepo.existsById(dto.getVid())) {
            throw new ValidationException("Vehicle is already in the system!");
        } else {
            Vehicle vehicle = mapper.map(dto, Vehicle.class);
            vehicleRepo.save(vehicle);
        }*/
        Car vehicle = mapper.map(dto, Car.class);
        vehicleRepo.save(vehicle);
    }

    @Override
    public void deleteCarCategory(String id) {
        if (vehicleRepo.existsById(id)) {
            vehicleRepo.deleteById(id);
        } else {
            throw new ValidationException("There is no any matching Vehicle Category in the system!");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (vehicleRepo.existsById(dto.getCarId())) {
            Car vehicle = mapper.map(dto, Car.class);
            vehicleRepo.save(vehicle);
        } else {
            throw new ValidationException("There is no any matching Vehicle Category in the system!");
        }
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = vehicleRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public ArrayList<CarDTO> findAllAvailableVehicles() {
        List<Car> all = vehicleRepo.findAll();
        for (int i = 0; i < all.size(); i++) {
            for (int j = 0; j < all.get(i).getVehicleDetailList().size(); j++) {
                //remove unavailable & currently maintaining vehicles from the list
                CarDetail vd = all.get(i).getVehicleDetailList().get(j);
                if (vd.getAvailability().equalsIgnoreCase("unavailable") || vd.getMaintenance().equalsIgnoreCase("yes")) {
                    all.get(i).getVehicleDetailList().remove(j);
                }
            }
        }
        return mapper.map(all, new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }

    @Override
    public CarDTO searchCar(String id) {
        Optional<Car> v = vehicleRepo.findById(id);
        if (v.isPresent()) {
            Car vehicle = v.get();
            return mapper.map(vehicle, CarDTO.class);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }

    @Override
    public String getLastVid() {
        return vehicleRepo.getLastVid();
    }
}
