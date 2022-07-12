package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerLicenseNumber;
    private String customerNicNumber;
    private String customerAddress;
    private String customerContactNumber;
}
