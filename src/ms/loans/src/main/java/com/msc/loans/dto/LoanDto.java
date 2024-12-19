package com.msc.loans.dto;

import java.math.BigDecimal;
import java.util.Date;

public record LoanDto(
        Long Id,
        boolean isActive,
        Date dateCreated,
        BigDecimal maxAmount,
        BigDecimal minAmount,
        Date maxFeasibleDate,
        Date minFeasibleDate,
        int loanStyleType,
        int loanQualityRating,
        String loanDescription
){}
