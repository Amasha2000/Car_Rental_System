package lk.easyCarRental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDetailDTO {
    private RDCompositeKeyDTO pk;
    private int qty;
    private String driver;
    private String pickup_date;
    private String return_date;
    private double rental_fee;
    private double ldw_fee;
    private String message;
    private String status;
}
