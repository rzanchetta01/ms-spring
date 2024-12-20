package com.msc.users.mapping;

import com.msc.users.dto.AccountDto;
import com.msc.users.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto toDto(Account account);
    List<AccountDto> toDto(List<Account> accounts);

    Account toEntity(AccountDto accountDto);
    List<Account> toEntity(List<AccountDto> accountDto);
}
