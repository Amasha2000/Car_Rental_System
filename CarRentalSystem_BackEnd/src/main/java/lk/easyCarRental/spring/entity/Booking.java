package lk.easyCarRental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Booking {
    private String bookingId;
    private LocalTime time;
    private LocalDate startingDate;
    private LocalDate endDate;
    private double ldwPayment;
    private double cost;
}
