package com.example.gmrestapi.entity;

import com.example.gmrestapi.entity.Abs.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AutoShop extends AbsNameEntity {
    @ManyToOne
    private Gm gm;
    @OneToOne
    private Address address;
}
