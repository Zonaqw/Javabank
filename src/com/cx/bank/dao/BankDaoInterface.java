
  package com.cx.bank.dao;

  import java.io.IOException;

  public interface BankDaoInterface {
    /**
     * �洢��ʽ˵��
     */
    void AddBank();

    /**
     * �û�ע��˵��
     * @param uname
     * @param upwd
     * @throws IOException
     */
      void register(String uname,String upwd) throws IOException;

    /**
     * �û���¼˵��
     * @param uname
     * @param upwd
     * @throws IOException
     */
      void login(String uname,String upwd) throws IOException;



    /**
     * ת��˵��
     * @param others
     * @param money
     * @throws IOException
     */
      void transfer(String others,String money) throws IOException;
  }
