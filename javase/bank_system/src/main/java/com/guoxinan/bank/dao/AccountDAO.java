package com.guoxinan.bank.dao;

import com.guoxinan.bank.domain.Account;

/**
 * 表示对用户数据处理的接口，规定了对数据进行访问的两个标准方法
 * 业务逻辑层只依赖接口，而不会去依赖DAO层的具体实现
 */
public interface AccountDAO {
    /**
     * 通过账户号返回一个Account对象
     * @param accountNumber 要查询到Account对象的accountNumber
     * @return 对应的Account对象
     */
    Account findAccountById(String accountNumber);

    /**
     * 完成对账户的更新
     * @param account 要更新的账户
     */
    void updateAccount(Account account);

}
