package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDetailDTO {
    private CompositeKeyDTO pk;
    private String pickup_date;
    private String return_time;
    private String return_date;
    private double rental_fee;
    private double ldw_fee;
}
