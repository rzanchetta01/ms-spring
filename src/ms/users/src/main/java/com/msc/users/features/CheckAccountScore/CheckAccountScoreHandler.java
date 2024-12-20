package com.msc.users.features.CheckAccountScore;

import com.msc.users.entities.Account;
import com.msc.users.interfaces.IAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckAccountScoreHandler {
    private final IAccountRepository accountRepository;

    public CheckAccountScoreHandler(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public double handle(CheckAccountScoreQuery request) {
        var entity = accountRepository.findById(request.accountId());

        return entity.map(Account::getCreditScore).orElse(0.0);
    }
}
