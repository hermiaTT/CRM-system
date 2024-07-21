package com.crmSystem.crm_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private Date serviceDate;
    private float TotalPaid;
}
