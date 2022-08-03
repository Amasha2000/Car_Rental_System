package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.Driver;
import lk.easyCarRental.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "SELECT driverId FROM Driver ORDER BY driverId DESC LIMIT 1", nativeQuery = true)
    String geLastDid();

    List<Driver> findAllByUserNotLike(User user);

    Optional<Driver> findByUser(User user);
}
