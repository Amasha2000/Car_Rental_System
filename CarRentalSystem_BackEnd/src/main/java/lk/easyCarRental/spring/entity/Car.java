package lk.easyCarRental.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.easyCarRental.spring.dto.CarDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {
    @Id
    private String carId;
    @JsonIgnore
    private String carBrand;
    @JsonIgnore
    private String type;
    @JsonIgnore
    private int numberOfPassengers;
    @JsonIgnore
    private String transmissionType;
    @JsonIgnore
    private int mileage;
    @JsonIgnore
    private String freeMileage;
    @JsonIgnore
    private double dailyRentPrice;
    @JsonIgnore
    private double monthlyRentPrice;
    @JsonIgnore
    private double ldwFee;
    @JsonIgnore
    private double extraKMPrice;
    @JsonIgnore
    private String fuelType;
    @JsonIgnore
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<CarDetail> vehicleDetailList;
}
