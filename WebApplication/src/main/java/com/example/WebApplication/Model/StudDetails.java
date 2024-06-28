package com.example.WebApplication.Model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudDetails {

    @Id
    private int id;
    private String name;
    private int mobNo;
    private String book;
}
