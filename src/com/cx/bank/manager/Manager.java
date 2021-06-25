
 package com.cx.bank.manager;

 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 /*�����ӿ�Manager,������Ҫʹ�õķ���
 * */
 public interface Manager {
    void exitSystem();
    double inquiry();
    void withdrawals(Double _money) throws AccountOverDrawnException;
    void deposit(Double _money) throws InvalidDepositException;
 }