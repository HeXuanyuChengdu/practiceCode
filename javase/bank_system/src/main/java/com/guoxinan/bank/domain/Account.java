package com.guoxinan.bank.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class Account {
    private String accountNumber;
    private String password;
    private BigDecimal balance;


    private Account(String accountNumber, String password, BigDecimal balance) {
        this.accountNumber = Objects.requireNonNull(accountNumber,"账号不能为空");
        this.password = Objects.requireNonNull(password,"密码不能为空");
        this.balance = balance;
    }
    private Account(){

    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public String getPassword() {
        return password;
    }
    public BigDecimal getBalance() {
        return balance;
    }

//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }


    /**
     * 完成取钱的业务
     * @param amount 用户要取的金额
     */
    public void withdraw(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("金额必须为正");
        }

        BigDecimal userAmount = new BigDecimal(amount);

        if (balance.compareTo(userAmount) < 0) {
            throw new IllegalArgumentException("余额不足");
        }

        balance = balance.subtract(userAmount);
    }

    /**
     * 完成用户要存钱的逻辑
     * @param amount 用户要存入的金额
     */
    public void deposit(double amount) {
        if(amount < 0){
            throw new IllegalArgumentException("金额必须大于等于0");
        }
        BigDecimal userAmount = new BigDecimal(amount);
        balance = balance.add(userAmount);
    }

    /**
     * 创建一个Account,金额为0
     * @param accountNumber 用户自定义的账户号
     * @param password 用户密码
     * @return 创建的新的账户实体
     */
    public static Account createAccount(String accountNumber, String password) throws IllegalArgumentException {
        //账户要求：8位数字
        String accountPattern = "[0-9]{8}";
        //密码要求：至少包含8个字符，必须包含大小写字母和数字
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";

        //校验账户
        if(!Pattern.matches(accountPattern, accountNumber)){
            throw new IllegalArgumentException("账户必须是8位纯数字!");
        }
        //校验密码
        if(!Pattern.matches(passwordPattern, password)){
            throw new IllegalArgumentException("密码必须包含大小写字母与数字，且8位以上!");
        }

        return new Account(accountNumber, password, new BigDecimal(0));

    }

    /**
     * 创建一个Account,金额由调用者提供
     * @param accountNumber 创建的账户id
     * @param password 创建的账户密码
     * @param balance 创建的账户金额
     * @return 创建的账户
     */
    public static Account createAccount(String accountNumber, String password,double balance)  {
        Account account = createAccount(accountNumber, password);
        account.deposit(balance);
        return account;
    }

    public String toString() {
        return getClass().getName()+"[accountNumber=" + accountNumber
                + ", password=" + password +
                ", balance=" + balance + "]";
    }


//    public static void main(String[] args){
//       String password = "123456";
//        Account acc = new Account(12345+"",password,BigDecimal.valueOf(1000L));
//        System.out.println(acc);
//    }

}
