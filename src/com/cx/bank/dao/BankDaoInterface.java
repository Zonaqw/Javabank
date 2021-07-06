package com.cx.bank.dao;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;

import java.io.IOException;

public interface BankDaoInterface{
    /**
     * 更新money
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    void updateMoney(UserBean userBean, MoneyBean moneyBean) throws IOException;

    /**
     * 插入用户
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    void insertUser(UserBean userBean, MoneyBean moneyBean) throws IOException;

    /**
     * 寻找用户
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    void findUser(UserBean userBean, MoneyBean moneyBean) throws IOException;

    /**
     * 转账
     * @param moneyBean
     * @param _uname
     * @param money
     * @throws IOException
     */

    void transfer(MoneyBean moneyBean, String _uname, String money) throws IOException;
}