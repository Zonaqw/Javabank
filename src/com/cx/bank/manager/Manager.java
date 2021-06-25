
 package com.cx.bank.manager;

 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 /*创建接口Manager,定义需要使用的方法
 * */
 public interface Manager {
    void exitSystem();
    double inquiry();
    void withdrawals(Double _money) throws AccountOverDrawnException;
    void deposit(Double _money) throws InvalidDepositException;
 }