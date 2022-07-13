package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
}
