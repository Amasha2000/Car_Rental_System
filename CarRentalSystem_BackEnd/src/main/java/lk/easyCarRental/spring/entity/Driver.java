package lk.easyCarRental.spring.entity;

import lk.easyCarRental.spring.dto.UserDTO;
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
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private User user;
    private String driverNicNumber;
    private String driverLicenseNumber;
    private String driverAddress;
    private String driverContactNumber;
    private String nic_image;
    private String dr_license_image;
    private String availability;
}
