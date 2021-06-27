
 package com.cx.bank.manager;

 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

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
    * 注册
    * @param _uname
    * @param _upwd
    * @return
    */
    boolean register(String _uname,String _upwd);

   /**
    * 登录
    * @param _uname
    * @param _upwd
    * @return
    */
    boolean login(String _uname,String _upwd);
 }