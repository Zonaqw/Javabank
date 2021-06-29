
  package com.cx.bank.dao;

  import java.io.IOException;

  public interface BankDaoInterface {
    /**
     * 存储方式说明
     */
    void AddBank();

    /**
     * 用户注册说明
     * @param uname
     * @param upwd
     * @throws IOException
     */
      void register(String uname,String upwd) throws IOException;

    /**
     * 用户登录说明
     * @param uname
     * @param upwd
     * @throws IOException
     */
      void login(String uname,String upwd) throws IOException;



    /**
     * 转账说明
     * @param others
     * @param money
     * @throws IOException
     */
      void transfer(String others,String money) throws IOException;
  }
