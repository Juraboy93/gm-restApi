package com.example.gmrestapi.dto;

import com.example.gmrestapi.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GmDto {
    private String corpName;
    private String director;
    private Address address;
    private String city;
    private String street;
    private String home;
}
