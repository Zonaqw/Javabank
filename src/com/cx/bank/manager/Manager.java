
 package com.cx.bank.manager;

 /*�����ӿ�Manager,���巽��
 * */
 public interface Manager {
    void exitSystem();
    double inquiry();
    void withdrawals(Double _money);
    void deposit(Double _money);
 }