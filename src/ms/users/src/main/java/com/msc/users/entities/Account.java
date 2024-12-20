package com.msc.users.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isActive;
    private Date dateCreated;
    private String name;
    private String email;
    private String password;
    private String cellphone;
    private Date birthday;
    private String country;
    private String state;
    private String city;
    private String postalCode;
    private String address;
    private String addressComplement;
    private BigDecimal income;
    private double creditScore;
}
