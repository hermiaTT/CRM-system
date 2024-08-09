package com.crmSystem.crm_backend.Collections;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
    private Timestamp serviceDate;

    @ElementCollection
    @CollectionTable(name = "service_images", joinColumns = @JoinColumn(name = "service_id"))
    @Column(name = "image")
    private List<byte[]> serviceImg; // Or use Set<byte[]> for uniqueness

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

//    @Column(name = "customer_id")
//    private Long customerId;
//
//    @Column(name = "employee_id")
//    private Long employeeId;

    public void setIsTaxed(boolean isTaxed) {
        this.isTaxed = isTaxed;
    }
    public boolean getIsTaxed() {
        return isTaxed;
    }

}
