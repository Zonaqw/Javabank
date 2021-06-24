
 package com.cx.bank.manager;


 public interface Manager {
    void exitSystem();
    double inquiry();
    boolean withdrawals(double _money);
    boolean deposit(double _money);
 }