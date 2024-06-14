package com.mapping.MappingExample.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int addressId;
    private String city;
    private String addressType;

}
