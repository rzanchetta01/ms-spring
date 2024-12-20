package com.msc.users.features.UpdateAccount;

import com.msc.users.dto.AccountDto;

public record UpdateAccountCommand(Long accountId, AccountDto accountDto) {
}
