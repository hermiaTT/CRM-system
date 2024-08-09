package com.crmSystem.crm_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private long birthday;
    private String vipType;
    private float balance;
    private String comingResource;
    private String firstLanguage;
    private String note;
    private boolean isVip;

    //setter getter for boolean
    public boolean getIsVip() {
        return isVip;
    }

}
