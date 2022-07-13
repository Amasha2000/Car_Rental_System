package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.BookingDTO;
import lk.easyCarRental.spring.entity.Booking;
import lk.easyCarRental.spring.repo.BookingRepo;
import lk.easyCarRental.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addBooking(BookingDTO dto) {
        if(!bookingRepo.existsById(dto.getBookingId())){
            bookingRepo.save(modelMapper.map(dto, Booking.class));
        }else{
            throw new RuntimeException("Booking already exists");
        }
    }

    @Override
    public void updateBooking(BookingDTO dto) {
        if(bookingRepo.existsById(dto.getBookingId())){
            bookingRepo.save(modelMapper.map(dto,Booking.class));
        }else{
            throw new RuntimeException("No such Booking Details to update");
        }
    }

    @Override
    public void deleteBooking(String id) {
        if(bookingRepo.existsById(id)){
            bookingRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such Booking Details to delete");
        }
    }

    @Override
    public BookingDTO searchBooking(String id) {
        if(bookingRepo.existsById(id)){
            return modelMapper.map(bookingRepo.findById(id).get(),BookingDTO.class);
        }else{
            throw new RuntimeException("No such Booking Details");
        }
    }

    @Override
    public ArrayList<BookingDTO> getAllBookings() {
        return modelMapper.map(bookingRepo.findAll(),new TypeToken<ArrayList<BookingDTO>>(){}.getType());
    }
}
