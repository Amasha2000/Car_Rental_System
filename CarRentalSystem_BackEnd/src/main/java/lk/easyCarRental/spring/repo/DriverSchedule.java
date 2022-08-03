package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface DriverSchedule extends JpaRepository<DriverSchedule,String> {

    @Query(value = "SELECT driver_sdid FROM DriverSchedule ORDER BY driver_sdid DESC LIMIT 1", nativeQuery = true)
    String getLastId();

    ArrayList<DriverSchedule> findAllByDriver(Driver driver);
}
