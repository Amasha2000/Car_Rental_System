package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.CarDTO;
import lk.easyCarRental.spring.entity.Car;
import lk.easyCarRental.spring.repo.CarRepo;
import lk.easyCarRental.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveCar(CarDTO carDTO) {
        if(!carRepo.existsById(carDTO.getCarId())){
            carRepo.save(modelMapper.map(carDTO, Car.class));
        }else {
            throw new RuntimeException("Car Already Exists");
        }
    }

    @Override
    public void updateCar(CarDTO carDTO) {
        if(carRepo.existsById(carDTO.getCarId())){
            carRepo.save(modelMapper.map(carDTO,Car.class));
        }else {
            throw new RuntimeException("No such a car to update");
        }
    }

    @Override
    public void deleteCar(String id) {
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
        }else {
            throw new RuntimeException("No such a car to delete");
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        if(carRepo.existsById(id)){
            return modelMapper.map(carRepo.findById(id).get(),CarDTO.class);
        }else{
            throw new RuntimeException("No such a Car");
        }
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        return modelMapper.map(carRepo.findAll(),new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }
}
