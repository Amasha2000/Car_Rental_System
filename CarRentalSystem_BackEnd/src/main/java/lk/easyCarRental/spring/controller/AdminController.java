package lk.easyCarRental.spring.controller;

import lk.easyCarRental.spring.dto.AdminDTO;
import lk.easyCarRental.spring.service.AdminService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil registerAdmin(@ModelAttribute AdminDTO dto){
        adminService.saveAdmin(dto);
        return new ResponseUtil(200,"Admin Saved",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
        adminService.updateAdmin(dto);
        return new ResponseUtil(200,"Admin Updated",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id){
        adminService.deleteAdmin(id);
        return new ResponseUtil(200,"Admin Deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@PathVariable String id){
        return new ResponseUtil(200,"OK",adminService.searchAdmin(id));
    }
}
