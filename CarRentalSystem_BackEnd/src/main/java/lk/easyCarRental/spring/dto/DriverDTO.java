package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
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
