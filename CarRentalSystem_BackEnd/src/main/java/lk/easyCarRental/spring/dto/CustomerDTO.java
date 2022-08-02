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
    private UserDTO userDTO;
    private String customerLicenseNumber;
    private String customerNicNumber;
    private String customerAddress;
    private String customerContactNumber;
    private String nic_image;
    private String dr_license_image;
}
