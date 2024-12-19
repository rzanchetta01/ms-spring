package com.msc.loans.features.createLoan;

import com.msc.loans.data.interfaces.ILoanRepository;
import com.msc.loans.mapping.LoanMapper;
import org.springframework.stereotype.Service;

@Service
public class CreateLoanHandler {

    private final ILoanRepository repository;


    public CreateLoanHandler(ILoanRepository repository) {
        this.repository = repository;
    }

    public void handle(CreateLoanCommand command) {

        repository.save(LoanMapper.INSTANCE.toEntity(command.request()));
    }
}
