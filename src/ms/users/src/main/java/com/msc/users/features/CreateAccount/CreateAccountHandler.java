package com.msc.users.features.CreateAccount;

import com.msc.users.dto.AccountDto;
import com.msc.users.entities.Account;
import com.msc.users.interfaces.IAccountRepository;
import com.msc.users.mapping.AccountMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

@Service
public class CreateAccountHandler {

    private final IAccountRepository accountRepository;

    public CreateAccountHandler(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void handle(CreateAccountCommand request) {

        Account entity = AccountMapper.INSTANCE.toEntity(request.accountDto());
        entity.setActive(true);
        entity.setDateCreated(new Date(System.currentTimeMillis()));
        entity.setCreditScore(defineStarAccountRating(request.accountDto()));

        accountRepository.save(entity);
    }

    private double defineStarAccountRating(AccountDto dto) {
        double creditScore = 0;
        if(dto.income().compareTo(BigDecimal.valueOf(6000)) >= 0) {
            creditScore += 1;
        }

        if(dto.addressComplement() != null && !dto.addressComplement().isBlank()) {
            creditScore += 2;
        }

        if(dto.name() != null && !dto.name().isBlank()) {
            creditScore += 1;
        }

        return creditScore;
    }
}
