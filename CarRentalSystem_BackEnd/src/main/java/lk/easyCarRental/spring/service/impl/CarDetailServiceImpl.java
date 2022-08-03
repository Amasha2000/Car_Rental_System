package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.CarDetailDTO;
import lk.easyCarRental.spring.entity.CarDetail;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.CarDetailRepo;
import lk.easyCarRental.spring.service.CarDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CarDetailServiceImpl implements CarDetailService {
    @Autowired
    private CarDetailRepo vehicleDetailRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public String getLastVDID() {
        return vehicleDetailRepo.getLastVDID();
    }

    @Override
    public String checkAvailability(String id) {
        System.out.println(id);
        return vehicleDetailRepo.checkAvailability(id);
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleDetailRepo.existsById(id)) {
            vehicleDetailRepo.deleteById(id);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }

    @Override
    public void updateVehicle(CarDetailDTO dto) {
        if (vehicleDetailRepo.existsById(dto.getVdid())) {
            CarDetail vehicleDetail = mapper.map(dto, CarDetail.class);
            vehicleDetailRepo.save(vehicleDetail);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }

    @Override
    public void updateVehicleAvailability(String id, String status) {
        Optional<CarDetail> vd = vehicleDetailRepo.findById(id);
        if (vd.isPresent()) {
            CarDetail vehicleDetail = vd.get();
            vehicleDetail.setAvailability(status);
        } else {
            throw new ValidationException("There is no any matching Vehicle in the system!");
        }
    }
}
