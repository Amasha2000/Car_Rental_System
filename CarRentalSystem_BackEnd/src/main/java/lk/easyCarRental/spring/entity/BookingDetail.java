package lk.easyCarRental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BookingDetail {
    @EmbeddedId
    private CompositeKey pk;

    @ManyToOne
    @JoinColumn(name = "bid", referencedColumnName = "bookingId", insertable = false, updatable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "vdid", referencedColumnName = "vdid", insertable = false, updatable = false)
    private CarDetail carDetail;

    @ManyToOne
    @JoinColumn(name = "did", referencedColumnName = "driverId", insertable = false, updatable = false)
    private Driver driver;

    private String pickup_date;
    private String return_date;
    private String return_time;
    private double rental_fee;
    private double ldw_fee;
}
