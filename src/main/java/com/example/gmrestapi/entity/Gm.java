package com.example.gmrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gm {

    private String corpName;
    private String director;
    @OneToOne
    private Address address;
}
