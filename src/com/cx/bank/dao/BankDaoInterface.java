package com.cx.bank.dao;

import com.cx.bank.model.MoneyBean;
import com.cx.bank.model.UserBean;

import java.io.IOException;

public interface BankDaoInterface{
    /**
     * ����money
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    void updateMoney(UserBean userBean, MoneyBean moneyBean) throws IOException;

    /**
     * �����û�
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    void insertUser(UserBean userBean, MoneyBean moneyBean) throws IOException;

    /**
     * Ѱ���û�
     * @param userBean
     * @param moneyBean
     * @throws IOException
     */
    void findUser(UserBean userBean, MoneyBean moneyBean) throws IOException;

    /**
     * ת��
     * @param moneyBean
     * @param _uname
     * @param money
     * @throws IOException
     */

    void transfer(MoneyBean moneyBean, String _uname, String money) throws IOException;
}