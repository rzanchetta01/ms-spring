package com.msc.loans.features.getAvailableLoansQuery;

import java.math.BigDecimal;


public record GetAvailableLoansQuery(Long accountId, String maxFeasibleDate, BigDecimal income, Integer creditScore) {
}
