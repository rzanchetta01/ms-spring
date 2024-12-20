package com.msc.users.features.GetAccountDetails;

import com.msc.users.dto.AccountDto;
import com.msc.users.interfaces.IAccountRepository;
import com.msc.users.mapping.AccountMapper;
import org.springframework.stereotype.Service;

@Service
public class GetAccountDetailsHandler {
    private final IAccountRepository accountRepository;

    public GetAccountDetailsHandler(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto handle(GetAccountDetailsQuery request) {
        var result = accountRepository.findById(request.accountId());

        return result.map(AccountMapper.INSTANCE::toDto).orElse(null);
    }
}
