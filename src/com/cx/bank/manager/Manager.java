
package com.cx.bank.manager;

import com.cx.bank.util.AccountOverDrawnException;
import com.cx.bank.util.InvalidDepositException;

import java.io.IOException;

public interface Manager{
    Double inquiry();
    void withdrawals(String qumoney) throws AccountOverDrawnException;
    void deposit(String cunmoney)throws InvalidDepositException;
    boolean register(String _uname,String _upwd) throws IOException;
    boolean login(String _uname,String _upwd) throws IOException;
    boolean transfer(String _uname,String money)throws IOException;
    void exitSystem() throws IOException;
}