package com.crmSystem.crm_backend.DataCollection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Document(collection = "services")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Services {

    private ObjectId id;
    private float TotalPaid;
    private Date serviceDate;

    @DocumentReference
    private List<ServiceInfo> services;
    //need to store images here



    public Services(float TotalPaid, Date serviceDate) {
        this.TotalPaid = TotalPaid;
        this.serviceDate = serviceDate;
    }
//    public Services(float TotalPaid, Date serviceDate, List<ServiceInfo> services) {
//        this.TotalPaid = TotalPaid;
//        this.serviceDate = serviceDate;
//        this.services = services;
//    }
}
