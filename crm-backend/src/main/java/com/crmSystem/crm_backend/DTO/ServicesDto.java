package com.crmSystem.crm_backend.DTO;

import com.crmSystem.crm_backend.Collections.ServiceInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDto {

    private ObjectId id;
    private float TotalPaid;
    private Date serviceDate;
//    private List<ServiceInfo> services;
}
