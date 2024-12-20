package com.msc.users.features.DeleteAccount;

import com.msc.users.interfaces.IAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountHandler {

    private final IAccountRepository accountRepository;

    public DeleteAccountHandler(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void handle(DeleteAccountCommand request) {
        accountRepository.deleteById(request.accountId());
    }
}