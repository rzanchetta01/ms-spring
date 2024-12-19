package com.msc.loans.endpoints;

import com.msc.loans.dto.LoanDto;
import com.msc.loans.features.createLoan.CreateLoanCommand;
import com.msc.loans.features.createLoan.CreateLoanHandler;
import com.msc.loans.features.getAvailableLoansQuery.GetAvailableLoansHandler;
import com.msc.loans.features.getAvailableLoansQuery.GetAvailableLoansQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    private final GetAvailableLoansHandler getAvailableLoansHandler;
    private final CreateLoanHandler createLoanHandler;

    public LoanController(GetAvailableLoansHandler getAvailableLoansHandler, CreateLoanHandler createLoanHandler) {
        this.getAvailableLoansHandler = getAvailableLoansHandler;
        this.createLoanHandler = createLoanHandler;
    }

    @PostMapping("get")
    public ResponseEntity<List<LoanDto>> getAvailableLoans(@RequestBody GetAvailableLoansQuery request) {
        try {
            var body = getAvailableLoansHandler.handle(request);

            return ResponseEntity.status(HttpStatus.OK).body(body);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("create")
    public ResponseEntity<String> createLoan(@RequestBody CreateLoanCommand request) {
        try {
            createLoanHandler.handle(request);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
