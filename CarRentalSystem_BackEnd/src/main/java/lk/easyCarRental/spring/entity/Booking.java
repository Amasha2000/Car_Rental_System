package lk.easyCarRental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Booking {
    @Id
    private String bookingId;
    private LocalTime time;
    private LocalDate startingDate;
    private LocalDate endDate;
    private double ldwPayment;
    private double cost;
}
