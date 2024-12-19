package com.msc.loans;

import com.msc.loans.data.interfaces.ILoanRepository;
import com.msc.loans.dto.LoanDto;
import com.msc.loans.entities.Loan;
import com.msc.loans.features.getAvailableLoansQuery.GetAvailableLoansHandler;
import com.msc.loans.features.getAvailableLoansQuery.GetAvailableLoansQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetAvailableLoansTests {
    private ILoanRepository loanRepository;
    private GetAvailableLoansHandler handler;

    @BeforeEach
    void setUp() {
        loanRepository = Mockito.mock(ILoanRepository.class);
        handler = new GetAvailableLoansHandler(loanRepository);
    }

    @Test
    void handle_WhenIncomeAndCreditScoreAreValid_ShouldReturnLoanDto() {
        // Arrange
        BigDecimal income = BigDecimal.valueOf(5000);
        int creditScore = 700;
        String maxFeasibleDate = "2024-12-31";
        var request = new GetAvailableLoansQuery(1L, maxFeasibleDate, income, creditScore);

        List<Loan> mockLoans = List.of(new Loan()); // Mocked list of loans

        when(loanRepository.getAllAvailableLoans(Date.valueOf(maxFeasibleDate)))
                .thenReturn(mockLoans);

        // Act
        List<LoanDto> result = handler.handle(request);

        // Assert
        assertNotNull(result);
        assertEquals(mockLoans.size(), result.size());
        verify(loanRepository, times(1)).getAllAvailableLoans(Date.valueOf(maxFeasibleDate));
    }

    @Test
    void handle_WhenIncomeIsZero_ShouldReturnEmptyList() {
        // Arrange
        BigDecimal income = BigDecimal.ZERO;
        int creditScore = 700;
        String maxFeasibleDate = "2024-12-31";
        var request = new GetAvailableLoansQuery(1L, maxFeasibleDate, income, creditScore);

        // Act
        List<LoanDto> result = handler.handle(request);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verifyNoInteractions(loanRepository);
    }

    @Test
    void handle_WhenCreditScoreIsZero_ShouldReturnEmptyList() {
        // Arrange
        BigDecimal income = BigDecimal.valueOf(5000);
        int creditScore = 0;
        String maxFeasibleDate = "2024-12-31";
        var request = new GetAvailableLoansQuery(1L, maxFeasibleDate, income, creditScore);

        // Act
        List<LoanDto> result = handler.handle(request);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verifyNoInteractions(loanRepository);
    }

    @Test
    void handle_WhenLoanRepositoryReturnsEmptyList_ShouldReturnEmptyList() {
        // Arrange
        BigDecimal income = BigDecimal.valueOf(5000);
        int creditScore = 700;
        String maxFeasibleDate = "2024-12-31";
        var request = new GetAvailableLoansQuery(1L, maxFeasibleDate, income, creditScore);

        when(loanRepository.getAllAvailableLoans(Date.valueOf(maxFeasibleDate)))
                .thenReturn(Collections.emptyList());

        // Act
        List<LoanDto> result = handler.handle(request);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(loanRepository, times(1)).getAllAvailableLoans(Date.valueOf(maxFeasibleDate));
    }
}
