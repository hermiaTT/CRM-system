package com.crmSystem.crm_backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customers {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Date brithDay;
    private List<Services> pastServices;
}
