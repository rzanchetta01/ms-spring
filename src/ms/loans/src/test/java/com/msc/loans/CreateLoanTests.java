package com.msc.loans;

import com.msc.loans.data.interfaces.ILoanRepository;
import com.msc.loans.dto.LoanDto;
import com.msc.loans.features.createLoan.CreateLoanCommand;
import com.msc.loans.features.createLoan.CreateLoanHandler;
import com.msc.loans.mapping.LoanMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CreateLoanTests {
    private ILoanRepository repository;
    private CreateLoanHandler createLoanHandler;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ILoanRepository.class);
        createLoanHandler = new CreateLoanHandler(repository);
    }

    @Test
    void testHandle_WhenValidCommand_ShouldSaveLoan() {
        // Arrange
        var loanCommand = new CreateLoanCommand(
                new LoanDto(
                        1L,
                        true,
                        new Date(),
                        BigDecimal.valueOf(1000),
                        BigDecimal.valueOf(10),
                        new Date(),
                        new Date(),
                        1,
                        5,
                        "random description"
                )
        );

        var loanEntity = LoanMapper.INSTANCE.toEntity(loanCommand.request());

        // Act
        createLoanHandler.handle(loanCommand);

        // Assert
        verify(repository, times(1)).save(loanEntity);
    }

    @Test
    void testHandle_WhenRepositoryThrowsException_ShouldPropagate() {
        // Arrange
        // Arrange
        var loanCommand = new CreateLoanCommand(
                new LoanDto(
                        1L,
                        true,
                        new Date(),
                        BigDecimal.valueOf(1000),
                        BigDecimal.valueOf(10),
                        new Date(),
                        new Date(),
                        1,
                        5,
                        "random description"
                )
        );

        var loanEntity = LoanMapper.INSTANCE.toEntity(loanCommand.request());

        doThrow(new RuntimeException("Database error"))
                .when(repository).save(loanEntity);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> createLoanHandler.handle(loanCommand));
    }
}
