package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookingDTO {
    private String bookingId;
    private String time;
    private String startingDate;
    private String endDate;
    private double ldwPayment;
    private double cost;
}
