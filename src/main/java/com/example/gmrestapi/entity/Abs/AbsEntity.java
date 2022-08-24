package com.example.gmrestapi.entity.Abs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@EqualsAndHashCode
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class AbsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String corpName;

    private String director;

    private String address;

}
