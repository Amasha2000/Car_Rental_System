package lk.easyCarRental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarSchedule {
    @Id
    private String vehicle_sdid;

    @ManyToOne
    @JoinColumn(name = "vdid", referencedColumnName = "vdid")
    private CarDetail carDetail;

    private String start_date;
    private String end_date;
}
