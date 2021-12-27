package com.cdp.amazonNeptune.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String customerName;

    private String phoneNumber;

    private String schemeCode;

    private String email;

    private String address;

    private String dateOfBirth;

    private String province;

    private String position;



}
