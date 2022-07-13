package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CarDTO {
    private String carId;
    private String carBrand;
    private String type;
    private String registrationNumber;
    private String color;
    private int numberOfPassengers;
    private String transmissionType;
    private int freeMileage;
    private double dailyRentPrice;
    private double monthlyRentPrice;
    private double extraKMPrice;
    private String fuelType;
}
