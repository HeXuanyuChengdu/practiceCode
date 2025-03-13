package main.java.homework.homework_03_12;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account myAccount = new Account("🕶","工商银行","12345678",Account.Type.DEBIT_CARD,5000);
        System.out.println(myAccount);

        System.out.println("请输入您要存取的金额:");
        double amount = sc.nextDouble();
        myAccount.deposit(amount);
        System.out.println("存钱成功！目前余额:"+myAccount.getAmount());

        System.out.println("请输入您要取出的金额:");
        amount = sc.nextDouble();
        if (myAccount.withdraw(amount) != null) {
            System.out.println("取钱成功！");
        }else {
            if (myAccount.getType() == Account.Type.CREDIT_CARD) {
                System.out.println("信用卡不能提现哦~");
            }else {
                System.out.println("取得钱超出您的余额了哦~");
            }
        }
    }

}

/**
 * {@code Account}对象代表银行的一个账号，有拥有者、创建银行、种类、<strong>字符串形式的卡号</strong>
 * 以及表示金额的BigDecimal类型的amount属性
 */
class Account{
    public enum Type{DEBIT_CARD, CREDIT_CARD};

    private String ownerName;
    private String creatBankName;
    private BigInteger value;
    private Type type;
    private BigDecimal amount;

    public Account(String ownerName, String creatBankName, String value, Type type, double amount) {
        this.ownerName = Objects.requireNonNull(ownerName);
        this.creatBankName = Objects.requireNonNull(creatBankName);
        this.value = BigInteger.valueOf(Long.parseLong(value));
        this.type = type;
        this.amount = BigDecimal.valueOf(amount);
    }

    public String getOwnerName() {
        return ownerName;
    }
    public String getCreatBankName() {
        return creatBankName;
    }
    public BigInteger getValue() {
        return value;
    }
    public Type getType() {
        return type;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 向账户里存钱
     * @param amount 要存储的金额
     */
    public void deposit(double amount) {
        this.amount = this.amount.add(BigDecimal.valueOf(amount));
    }

    /**
     * 从账户中取钱
     * @param amount 要取出的金额
     * @return 若取出的金额符合范围，返回金额，否则返回null
     */
    public BigDecimal withdraw(double amount) {
        if (this.type == Type.DEBIT_CARD) {
            if (amount > this.amount.doubleValue()) {
               // System.out.println("取出的金额超出范围!");
                return null;
            }else {
                this.amount = this.amount.subtract(BigDecimal.valueOf(amount));
               // System.out.println("取钱成功");
                return this.amount;
            }
        }else {
           // System.out.println();
            return null;
        }

    }

    public String toString(){
        return "[持卡人:"+this.ownerName
                +",开户行:" +this.creatBankName
                +",卡号:"+this.value
                +",卡的种类:"+(switch(this.type){
                    case DEBIT_CARD -> "储蓄卡";
                    case CREDIT_CARD -> "信用卡";
                })
                +"卡中余额:"+this.amount+"]";
    }

}