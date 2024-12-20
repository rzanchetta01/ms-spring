package com.msc.users.mapping;

import com.msc.users.dto.AccountActivityHistoryDto;
import com.msc.users.entities.AccountActivityHistory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountActivityMapper {

    AccountActivityMapper INSTANCE = Mappers.getMapper(AccountActivityMapper.class);

    AccountActivityHistoryDto toDto(AccountActivityHistory accountActivityHistory);
    List<AccountActivityHistoryDto> toDto(List<AccountActivityHistory> accountActivityHistoryList);
    
    AccountActivityHistory toEntity(AccountActivityHistoryDto accountActivityHistoryDto);
    List<AccountActivityHistory> toEntity(List<AccountActivityHistoryDto> accountActivityHistoryDtoList);
}
