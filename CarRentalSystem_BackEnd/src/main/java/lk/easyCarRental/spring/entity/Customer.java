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
public class Customer {
    @Id
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerLicenseNumber;
    private String customerNicNumber;
    private String customerAddress;
    private String customerContactNumber;
}
