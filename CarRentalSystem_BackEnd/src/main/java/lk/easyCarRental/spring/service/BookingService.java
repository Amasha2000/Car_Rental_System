package lk.easyCarRental.spring.service;

import lk.easyCarRental.spring.dto.BookingDTO;

import java.util.ArrayList;

public interface BookingService {
    void addBooking(BookingDTO dto);
    void updateBooking(BookingDTO dto);
    void deleteBooking(String id);
    BookingDTO searchBooking(String id);
    ArrayList<BookingDTO> getAllBookings();
}
