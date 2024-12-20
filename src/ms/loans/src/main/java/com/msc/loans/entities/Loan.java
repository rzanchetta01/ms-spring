package com.msc.loans.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isActive;
    private Date dateCreated;
    private BigDecimal maxAmount;
    private BigDecimal minAmount;
    private Date maxFeasibleDate;
    private Date minFeasibleDate;
    private int loanStyleType;
    private int loanQualityRating;
    private String loanDescription;
}