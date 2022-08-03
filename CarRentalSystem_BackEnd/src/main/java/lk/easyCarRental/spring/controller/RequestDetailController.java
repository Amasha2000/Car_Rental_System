package lk.easyCarRental.spring.controller;

import lk.easyCarRental.spring.dto.RequestDetailDTO;
import lk.easyCarRental.spring.service.RequestDetailService;

import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request_detail")
@CrossOrigin
public class RequestDetailController {

    @Autowired
    private RequestDetailService requestDetailService;

    @PutMapping(path = "update_request_message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateRequestMessage(@RequestBody RequestDetailDTO dto) {
        requestDetailService.updateRequestMessage(dto);
        return new ResponseEntity(new ResponseUtil(200, "Request confirmed!", null), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "delete_request_details", params = {"rid", "vid"})
    public ResponseEntity deleteRequestDetails(@RequestParam String rid, @RequestParam String vid) {
        requestDetailService.deleteRequestDetails(rid, vid);
        return new ResponseEntity(new ResponseUtil(200, "Request deleted!", null), HttpStatus.OK);
    }
}