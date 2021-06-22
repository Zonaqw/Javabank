package com.cx.bank.manager;


public interface Manager {
    void exitSystem();
    double inquiry();
    double withdrawals(double _money);
    double deposit(double _money);
}
