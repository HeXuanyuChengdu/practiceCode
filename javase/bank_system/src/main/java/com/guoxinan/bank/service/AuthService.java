package com.guoxinan.bank.service;

import com.guoxinan.bank.dao.AccountDAO;
import com.guoxinan.bank.domain.Account;
import com.guoxinan.bank.domain.State;

public class AuthService {
    private AccountDAO accountDAO;

    public AuthService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    /**
     * 调用DAO接口，验证登录是否正确
     * @param accountNumber 用户输入的账号
     * @param password 用户输入的密码
     * @return 账号与密码匹配，则返回true,否则返回false
     */
    public boolean login(String accountNumber, String password) {
        Account account = accountDAO.findAccountById(accountNumber);
        System.out.println(account);
        return account != null && account.getPassword().equals(password);
    }





}
