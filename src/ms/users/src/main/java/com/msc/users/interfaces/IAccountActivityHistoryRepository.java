package com.msc.users.interfaces;

import com.msc.users.entities.AccountActivityHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountActivityHistoryRepository extends JpaRepository<AccountActivityHistory, Long> {
}
