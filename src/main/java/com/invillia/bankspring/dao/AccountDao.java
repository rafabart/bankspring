package com.invillia.bankspring.dao;

import com.invillia.bankspring.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao extends GenericDao<Account, Long> {
    public AccountDao() {
        super(Account.class);
    }
}