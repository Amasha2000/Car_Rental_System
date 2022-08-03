package lk.easyCarRental.spring.controller;

import lk.easyCarRental.spring.dto.BookingDetailDTO;
import lk.easyCarRental.spring.service.BookingDetailService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking_detail")
@CrossOrigin
public class BookingDetailController {
    @Autowired
    private BookingDetailService bookingDetailService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBookingDetails(@RequestBody BookingDetailDTO dto) {
        bookingDetailService.updateBookingDetails(dto);
        return new ResponseEntity(new ResponseUtil(200, "Booking details updated!", null), HttpStatus.OK);
    }
}
