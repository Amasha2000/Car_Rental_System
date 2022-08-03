package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.BookingDTO;
import lk.easyCarRental.spring.entity.Booking;
import lk.easyCarRental.spring.exception.ValidationException;
import lk.easyCarRental.spring.repo.BookingRepo;
import lk.easyCarRental.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void addBooking(BookingDTO dto) {
        if (bookingRepo.existsById(dto.getBookingId())) {
            throw new ValidationException("Booking Id is already in the system..Create a new booking..");
        } else {
            Booking booking = mapper.map(dto, Booking.class);
            bookingRepo.save(booking);
        }
    }

    @Override
    public String getLastBookingId() {
        return bookingRepo.geLastBookingId();
    }

    @Override
    public ArrayList<BookingDTO> getAllBookings() {
        List<Booking> all = bookingRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<BookingDTO>>() {
        }.getType());
    }

    @Override
    public void updateBooking(String id, double fee) {
        if (bookingRepo.existsById(id)) {
            Booking booking = bookingRepo.getById(id);
            double old_total_fee = booking.getCost();
            booking.setCost(old_total_fee + fee);
        } else {
            throw new ValidationException("There is no any matching booking");
        }
    }
}
