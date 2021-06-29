
 package com.cx.bank.manager;

 import com.cx.bank.util.*;

 import java.io.IOException;

 /*创建接口Manager,定义需要使用的方法
 * */
 public interface Manager {
   /**
    * 退出系统
    */
    void exitSystem();

   /**
    * 查询余额
    * @return
    */
    double inquiry();

   /**
    * 取款
    * @param _money
    * @throws AccountOverDrawnException
    */
    void withdrawals(Double _money) throws AccountOverDrawnException;

   /**
    * 存款
    * @param _money
    * @throws InvalidDepositException
    */
    void deposit(Double _money) throws InvalidDepositException;

   /**
    *
    *
    * @param _uname
    * @param _upwd
    * @throws RegisterException
    * @throws IOException
    */
    void register(String _uname,String _upwd) throws RegisterException, IOException;

   /**
    *
    * @param _uname
    * @param _upwd
    * @throws LoginException
    * @throws IOException
    */
    void login(String _uname,String _upwd) throws LoginException, IOException;

   /**
    *
    * @param others
    * @param money
    * @throws IOException
    * @throws TransferException
    */
    void transfer(String others,String money) throws IOException, TransferException;
 }