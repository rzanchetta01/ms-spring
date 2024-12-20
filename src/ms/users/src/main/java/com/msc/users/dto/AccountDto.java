package com.msc.users.dto;

import java.math.BigDecimal;
import java.sql.Date;

public record AccountDto(
        String name,
        String email,
        String password,
        String cellphone,
        Date birthday,
        String country,
        String state,
        String city,
        String postalCode,
        String address,
        String addressComplement,
        BigDecimal income,
        double creditScore
) {}
