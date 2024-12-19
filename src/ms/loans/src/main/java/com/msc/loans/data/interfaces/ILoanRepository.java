package com.msc.loans.data.interfaces;

import com.msc.loans.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ILoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.isActive = true AND l.maxFeasibleDate <= ?1 ORDER BY l.dateCreated DESC")
    List<Loan> getAllAvailableLoans(Date maxFeasibleLoanApplyData);
}
