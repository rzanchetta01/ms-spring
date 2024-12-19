package com.msc.loans.mapping;

import com.msc.loans.dto.LoanDto;
import com.msc.loans.entities.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    Loan toEntity(LoanDto loanDto);
    LoanDto toDto(Loan loan);

    List<LoanDto> toDto (List<Loan> loanList);
}
