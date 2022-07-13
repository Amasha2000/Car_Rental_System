package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {
}
