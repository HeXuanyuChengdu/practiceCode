package com.guoxinan.bank.service;

import com.guoxinan.bank.dao.AccountDAO;
import com.guoxinan.bank.domain.Account;
import com.guoxinan.bank.domain.State;

import java.math.BigDecimal;

public class BankService {
    private AccountDAO accountDAO;


    public BankService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    /**
     * 调度领域模型，封装取钱逻辑
     * @param amount 用户要存入的金额
     * @param account 要存钱的实体
     */
    public boolean withdraw(Account account, double amount) {
        try {
            account.withdraw(amount);
            accountDAO.updateAccount(account);
            return true;
        }catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("操作失败"+e.getMessage());
            return false;
        }


    }

    /**
     * 调度领域模型，完成存钱逻辑
     * @param account 要存钱的账户实体
     * @param amount 要存的金额
     */
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }


}
