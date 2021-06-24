
 package com.cx.bank.manager;

 /*创建接口Manager,定义方法
 * */
 public interface Manager {
    void exitSystem();
    double inquiry();
    void withdrawals(Double _money);
    void deposit(Double _money);
 }