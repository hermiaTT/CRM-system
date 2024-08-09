package com.crmSystem.crm_backend.DTO;

import lombok.*;

import java.util.Date;
import java.util.List;

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
    private long serviceDate;
    private List<byte[]> serviceImg;
    private String customerName;
    private String employeeName;
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
