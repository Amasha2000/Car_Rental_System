package lk.easyCarRental.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class BookingDTO {
    private String bookingId;
    @JsonFormat(pattern="H:mm:ss")
    private LocalTime time;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startingDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    private double ldwPayment;
    private double cost;
}
