package com.msc.users.features.UpdateAccount;

import com.msc.users.mapping.AccountMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UpdateAccountHandler {
    @PersistenceContext
    private EntityManager entityManager;

    public void handle(UpdateAccountCommand request) {
        var entity = AccountMapper.INSTANCE.toEntity(request.accountDto());
        entity.setId(request.accountId());
        entity.setActive(true);
        entity.setDateCreated(new Date(System.currentTimeMillis()));

        entityManager.merge(entity);
    }
}
