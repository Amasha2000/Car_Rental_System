package lk.easyCarRental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Request {
    @Id
    private String rid;

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "customerId")
    private Customer customer;

    private double total_fee;
    private String bank_slip;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<RequestDetail> request_detail_list;
}
