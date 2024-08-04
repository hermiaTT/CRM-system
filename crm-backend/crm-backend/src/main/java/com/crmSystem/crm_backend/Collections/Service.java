package com.crmSystem.crm_backend.Collections;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "services")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "service_price")
    private float servicePrice;

    @Column(name = "is_taxed")
    private boolean isTaxed;

    @Column(name = "tips")
    private float tips;

    @Column(name = "total_paid")
    private float totalPaid;

    @Column(name = "service_date")
    private Date serviceDate;

    @Column(name = "service_img")
    private byte[] serviceImg;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
//    private Customer customer;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
//    private Employee employee;
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "employee_id")
    private Long employeeId;


    public boolean getIsTaxed() {
        return isTaxed;
    }

}
