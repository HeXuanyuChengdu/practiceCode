package com.guoxinan.bank.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Account {
    private BigInteger accountNumber;
    private char[] password;
    private BigDecimal balance;

    public Account(BigInteger accountNumber, char[] password, BigDecimal balance) {
        this.accountNumber = Objects.requireNonNull(accountNumber,"账号不能为空");
    }

}
