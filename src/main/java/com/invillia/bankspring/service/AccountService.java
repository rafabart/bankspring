package com.invillia.bankspring.service;

import com.invillia.bankspring.dao.AccountDao;
import com.invillia.bankspring.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao personDao) {
        this.accountDao = personDao;
    }

    public void deposit(Account account, Double valor) {
        account.setBalance(account.getBalance() + valor);
        update(account);
    }

    public boolean withdraw(Account account, Double valor) {

        if (account.getAccountTipyEnum().type.equals("CHECKING")) {
            if (!(account.getBalance() - valor < (-1 * account.getLimitAccount()))) {
                account.setBalance(account.getBalance() - valor);
                update(account);
                return true;
            }
        }
        return false;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findOne(Long id) {
        return accountDao.findById(id).get();
    }

    public void insert(Account account) {
        accountDao.insert(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Long id) {
        accountDao.deleteById(id);
    }
}
