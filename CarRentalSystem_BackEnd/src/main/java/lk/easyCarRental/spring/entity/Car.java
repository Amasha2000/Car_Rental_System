package lk.easyCarRental.spring.entity;

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
public class Car {
    @Id
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

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    private List<Booking> booking;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "admin",referencedColumnName = "adminId")
    private Admin admin;
}
