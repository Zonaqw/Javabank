
 package com.cx.bank.manager;

 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 /*�����ӿ�Manager,������Ҫʹ�õķ���
 * */
 public interface Manager {
   /**
    * �˳�ϵͳ
    */
    void exitSystem();

   /**
    * ��ѯ���
    * @return
    */
    double inquiry();

   /**
    * ȡ��
    * @param _money
    * @throws AccountOverDrawnException
    */
    void withdrawals(Double _money) throws AccountOverDrawnException;

   /**
    * ���
    * @param _money
    * @throws InvalidDepositException
    */
    void deposit(Double _money) throws InvalidDepositException;

   /**
    * ע��
    * @param _uname
    * @param _upwd
    * @return
    */
    boolean register(String _uname,String _upwd);

   /**
    * ��¼
    * @param _uname
    * @param _upwd
    * @return
    */
    boolean login(String _uname,String _upwd);
 }