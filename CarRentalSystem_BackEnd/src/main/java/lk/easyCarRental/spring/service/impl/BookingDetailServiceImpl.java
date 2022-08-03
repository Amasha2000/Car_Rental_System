package lk.easyCarRental.spring.service.impl;

import lk.easyCarRental.spring.dto.BookingDetailDTO;
import lk.easyCarRental.spring.entity.BookingDetail;
import lk.easyCarRental.spring.repo.BookingDetailRepo;
import lk.easyCarRental.spring.service.BookingDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingDetailServiceImpl implements BookingDetailService {


    @Autowired
    private BookingDetailRepo bookingDetailRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void updateBookingDetails(BookingDetailDTO dto) {
        BookingDetail bookingDetail = mapper.map(dto, BookingDetail.class);
        bookingDetailRepo.save(bookingDetail);
    }
}
