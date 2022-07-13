package lk.easyCarRental.spring.controller;


import lk.easyCarRental.spring.dto.BookingDTO;
import lk.easyCarRental.spring.service.BookingService;
import lk.easyCarRental.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/book")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil viewBookingDetails(){
        return new ResponseUtil(200,"ok",bookingService.getAllBookings());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addBooking(@ModelAttribute BookingDTO dto){
        bookingService.addBooking(dto);
        return new ResponseUtil(200,"Booking Added",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBooking(@RequestBody BookingDTO dto){
        bookingService.updateBooking(dto);
        return new ResponseUtil(200,"Booking Updated",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteBooking(@RequestParam String id){
        bookingService.deleteBooking(id);
        return new ResponseUtil(200,"Booking Deleted",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path ="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchBooking(@PathVariable String id){
        return new ResponseUtil(200,"OK", bookingService.searchBooking(id));
    }
}
