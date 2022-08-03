package lk.easyCarRental.spring.controller;


import lk.easyCarRental.spring.dto.BookingDTO;
import lk.easyCarRental.spring.service.BookingService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBooking(@RequestBody BookingDTO dto) {
        bookingService.addBooking(dto);
        return new ResponseEntity(new ResponseUtil(200, "Booking was successful!", dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getAllBookings() {
        ArrayList<BookingDTO> all = bookingService.getAllBookings();
        return new ResponseEntity(new ResponseUtil(200, "Done", all), HttpStatus.OK);
    }

    @GetMapping(path = "/last_id")
    public ResponseEntity getLastBookingId() {
        String lastBookingId = bookingService.getLastBookingId();
        return new ResponseEntity(new ResponseUtil(200, "Done", lastBookingId), HttpStatus.OK);
    }

    @PutMapping(params = {"id", "fee"})
    public ResponseEntity updateBooking(@RequestParam String id, @RequestParam double fee) {
        bookingService.updateBooking(id, fee);
        return new ResponseEntity(new ResponseUtil(200, "Booking details updated!", null), HttpStatus.OK);
    }
}
