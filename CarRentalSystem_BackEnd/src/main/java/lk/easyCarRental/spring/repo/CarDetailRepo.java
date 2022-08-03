package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarDetailRepo extends JpaRepository<CarDetail,String> {
    @Query(value = "SELECT vdid FROM CarDetail ORDER BY vdid DESC LIMIT 1", nativeQuery = true)
    String getLastVDID();

    @Query(value = "SELECT availability FROM CarDetail WHERE vid=?1", nativeQuery = true)
    String checkAvailability(String id);
}
