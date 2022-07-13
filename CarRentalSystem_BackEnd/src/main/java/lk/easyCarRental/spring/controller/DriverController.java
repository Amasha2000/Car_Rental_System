package lk.easyCarRental.spring.controller;

import lk.easyCarRental.spring.dto.DriverDTO;
import lk.easyCarRental.spring.service.DriverService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;
    
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil(200,"OK",driverService.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO dto){
        driverService.saveDriver(dto);
        return new ResponseUtil(200,"Driver Saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto){
        driverService.updateDriver(dto);
        return new ResponseUtil(200,"Driver Updated",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id){
        driverService.deleteDriver(id);
        return new ResponseUtil(200,"Driver Deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/{id}")
    public ResponseUtil searchDriver(@PathVariable String id){
        return new ResponseUtil(200,"Ok",driverService.searchDriver(id));
    }
}
