package lk.easyCarRental.spring.repo;

import lk.easyCarRental.spring.entity.Car;
import lk.easyCarRental.spring.entity.Request;
import lk.easyCarRental.spring.entity.RequestDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDetailRepo extends JpaRepository<RequestDetail,String> {

    boolean existsByRequest(Request request);

    void deleteByRequestAndVehicle(Request request, Car car);
}
