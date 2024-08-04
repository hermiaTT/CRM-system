package com.crmSystem.crm_backend.Collections;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(columnNames = "phone_number"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "vip_type")
    private String vipType;

    @Column(name = "balance")
    private float balance;

    @Column(name = "coming_resource")
    private String comingResource;

    @Column(name = "first_language")
    private String firstLanguage;

    @Column(name = "note")
    private String note;


    @Column(name = "is_vip")
    private boolean isVip;

    //setter getter for boolean
    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public boolean getIsVip() {
        return isVip;
    }
}
