
 package com.cx.bank.manager;

 import com.cx.bank.util.*;

 import java.io.IOException;

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