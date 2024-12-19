package com.msc.loans.features.getAvailableLoansQuery;

import com.msc.loans.data.interfaces.ILoanRepository;
import com.msc.loans.dto.LoanDto;
import com.msc.loans.entities.Loan;
import com.msc.loans.mapping.LoanMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Service
public class GetAvailableLoansHandler {
    private final ILoanRepository loanRepository;

    public GetAvailableLoansHandler(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public List<LoanDto> handle(GetAvailableLoansQuery request) {
        if (request.income().compareTo(BigDecimal.ZERO) > 0 && request.creditScore() > 0) {
            List<Loan> result = loanRepository.getAllAvailableLoans(Date.valueOf(request.maxFeasibleDate()));
            return LoanMapper.INSTANCE.toDto(result);
        }

        return Collections.emptyList();
    }
}
