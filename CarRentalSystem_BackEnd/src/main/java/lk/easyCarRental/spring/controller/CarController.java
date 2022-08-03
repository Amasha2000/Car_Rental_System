package lk.easyCarRental.spring.controller;

import lk.easyCarRental.spring.dto.CarDTO;
import lk.easyCarRental.spring.service.CarService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService vehicleService;

    @GetMapping
    public ResponseEntity getAllVehicles() {
        ArrayList<CarDTO> allVehicles = vehicleService.getAllCars();
        return new ResponseEntity(new ResponseUtil(200, "Done!", allVehicles), HttpStatus.CREATED);
    }

    @GetMapping(path = "/available_vehicles")
    public ResponseEntity getAllAvailableVehicles() {
        ArrayList<CarDTO> allVehicles = vehicleService.findAllAvailableVehicles();
        return new ResponseEntity(new ResponseUtil(200, "Done!", allVehicles), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchVehicle(@PathVariable String id) {
        CarDTO vehicle = vehicleService.searchCar(id);
        System.out.println("Vehicle id: " + vehicle.getCarId());
        return new ResponseEntity(new ResponseUtil(200, "Done!", vehicle), HttpStatus.CREATED);
    }

    @GetMapping(path = "/lastid")
    public ResponseEntity getLastVid() {
        String lastVid = vehicleService.getLastVid();
        return new ResponseEntity(new ResponseUtil(200, "Done", lastVid), HttpStatus.CREATED);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addVehicle(@RequestBody CarDTO dto) {
        vehicleService.saveCar(dto);
        return new ResponseEntity(new ResponseUtil(200, "Vehicle saved successfully!", dto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVehicleCategory(@RequestBody CarDTO dto) {
        vehicleService.updateCar(dto);
        return new ResponseEntity(new ResponseUtil(200, "Vehicle category updated successfully!", dto), HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteVehicleCategory(@RequestParam String id) {
        vehicleService.deleteCarCategory(id);
        return new ResponseEntity(new ResponseUtil(200, "Vehicle category was deleted!!", null), HttpStatus.CREATED);
    }
}
