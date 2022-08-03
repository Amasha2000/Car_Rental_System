package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailRepo extends JpaRepository<BookingDetail,String> {
}
