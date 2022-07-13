package lk.easyCarRental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverEmail;
    private String driverPassword;
    private String driverNicNumber;
    private String driverLicenseNumber;
    private String driverAddress;
    private String driverContactNumber;
    private int driverAge;
}
