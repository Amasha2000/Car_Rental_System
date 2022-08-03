package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.BookingDTO;

import java.util.ArrayList;

public interface BookingService {
    void addBooking(BookingDTO dto);
    String getLastBookingId();
    ArrayList<BookingDTO> getAllBookings();
    void updateBooking(String id, double fee);

}
