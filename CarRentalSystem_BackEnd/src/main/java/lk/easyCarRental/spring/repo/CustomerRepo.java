package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.Customer;
import lk.easyCarRental.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Optional<Customer> findByUser(User user);

    @Query(value = "SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1", nativeQuery = true)
    String geLastCid();
}
