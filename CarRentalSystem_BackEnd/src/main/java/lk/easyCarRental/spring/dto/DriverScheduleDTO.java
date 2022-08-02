package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverScheduleDTO {
    private String driver_sdid;
    private DriverDTO driver;
    private String start_date;
    private String end_date;
}
