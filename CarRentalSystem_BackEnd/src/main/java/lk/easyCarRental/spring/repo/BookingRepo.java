package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepo extends JpaRepository<Booking,String> {
    @Query(value = "SELECT bookingId FROM Booking ORDER BY bookingId DESC LIMIT 1", nativeQuery = true)
    String geLastBookingId();
}
