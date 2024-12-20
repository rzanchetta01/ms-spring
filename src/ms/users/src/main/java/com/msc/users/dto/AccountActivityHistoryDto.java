package com.msc.users.dto;

public record AccountActivityHistoryDto (
    Long accountId,
    Long loanId,
    boolean isReceiver
){}
