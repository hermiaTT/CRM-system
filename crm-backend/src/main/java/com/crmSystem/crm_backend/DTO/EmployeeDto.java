package com.crmSystem.crm_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String payRate;
    private String sin;

}
