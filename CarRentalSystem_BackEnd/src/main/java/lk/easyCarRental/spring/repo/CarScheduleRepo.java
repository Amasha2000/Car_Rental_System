package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.CarSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarScheduleRepo extends JpaRepository<CarSchedule,String> {

    @Query(value = "SELECT vehicle_sdid FROM CarSchedule ORDER BY vehicle_sdid DESC LIMIT 1", nativeQuery = true)
    String getLastId();
}
