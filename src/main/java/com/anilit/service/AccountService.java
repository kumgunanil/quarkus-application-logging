package com.anilit.service;

import com.anilit.dto.Account;
import com.anilit.resource.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AccountService {

    public static final Logger LOG = Logger.getLogger(AccountService.class);

    public boolean isAccountAlreadyExist(Account account1) {
        LOG.info("Entering in AccountService::isAccountAlreadyExist()");
        LOG.debug("AccountService::isAccountAlreadyExist() account " + account1);

        Account account = getAccountByAccNumber(account1.getAccountNumber());
        LOG.debug("AccountService::isAccountAlreadyExist() Account " + account);
        if (account != null) {
            LOG.info("Returning from AccountService::isAccountAlreadyExist()");
            return true;
        }else {
            LOG.info("Returning from AccountService::isAccountAlreadyExist()");
            return openNewAccount(account1);
        }
    }

    private boolean openNewAccount(Account accountNumber) {
        LOG.info("Entering in AccountService::openNewAccount()");
        LOG.debug("AccountService::openNewAccount() Account " + accountNumber);
        LOG.info("Returning from AccountService::openNewAccount()");
        return true;
    }

    private Account getAccountByAccNumber(long accountNumber) {
        LOG.info("Entering in AccountService::getAccountByAccNumber()");
        LOG.debug("AccountService::getAccountByAccNumber() accountNumber " + accountNumber);
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setName("Anil");
        LOG.debug("AccountService::getAccountByAccNumber() accountNumber " + account);
        LOG.info("Returning from AccountService::getAccountByAccNumber()");
        return account;
    }
}
