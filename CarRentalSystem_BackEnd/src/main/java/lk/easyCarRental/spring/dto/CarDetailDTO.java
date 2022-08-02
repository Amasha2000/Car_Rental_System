package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDetailDTO {
    private String vdid;
    private CarDTO vehicle;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String reg_number;
    private String color;
    private String availability;
    private String maintenance;
}
