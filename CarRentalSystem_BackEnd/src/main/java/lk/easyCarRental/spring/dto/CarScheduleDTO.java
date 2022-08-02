package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarScheduleDTO {
    private String vehicle_sdid;
    private CarDetailDTO vehicle;
    private String start_date;
    private String end_date;
}
