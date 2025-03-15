package com.guoxinan.bank.service;

import com.guoxinan.bank.dao.AccountDAO;
import com.guoxinan.bank.dao.FileAccountDAO;
import com.guoxinan.bank.domain.Account;
import com.guoxinan.bank.domain.State;

public class RegisterService {

    private AccountDAO accountDAO;

    public RegisterService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    /**
     * 调度DAO，完成注册逻辑
     * @param accountNumber
     * @param password
     * @return
     */
    public boolean register(String accountNumber, String password) {
        //判断如果账号已存在，则不许注册
        Account existingAccount = accountDAO.findAccountById(accountNumber);
        if (existingAccount != null) {
            throw new IllegalArgumentException("账号已存在");
        }

        try {
            Account account = Account.createAccount(accountNumber, password);
            accountDAO.updateAccount(account);
            System.out.println("Account " + account.getAccountNumber() + "成功注册");
            return true;
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.err.println("操作失败格式不正确：" + e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
            //return false;
        }

    }

    public static void main(String[] args) {
        RegisterService registerService = new RegisterService(new FileAccountDAO());
        String testAccountNumber = "20250002";
        String testPassword = "Hexuanyu1111";
        if ( registerService.register(testAccountNumber, testPassword)) {
           System.out.println("成功");
        }else {
            System.out.println("失败");
        }
    }
}
