package com.crmSystem.crm_backend.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {

    private Long id;
    private String serviceType;
    private float servicePrice;
    private boolean isTaxed;
    private float tips;
    private float totalPaid;
    private Date serviceDate;
    private byte[] serviceImg;
    private Long customerId; // Use IDs for customer
    private Long employeeId; // Use IDs for employee

    //setter getter for boolean
    public void setIsTaxed(boolean isTaxed) {
        this.isTaxed = isTaxed;
    }

    public boolean getIsTaxed() {
        return isTaxed;
    }
}
