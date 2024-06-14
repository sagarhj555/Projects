package com.mapping.MappingExample.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int id;
    private String name;
    private String email;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_emp_add")
    private Address address;*/

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_emp_add", referencedColumnName = "emp_id")
    private List<Address> address;*/

}
