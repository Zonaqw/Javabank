
  package com.cx.bank.dao;

  import com.cx.bank.model.MoneyBean;
  import com.cx.bank.model.UserBean;

  import java.io.*;
  import java.util.Properties;

  /*@projectName Javabank
  * @package com.cx.bank.dao
  * @className BankDaoImpl
  * @description 用于实现各种功能模块的数据存储
  * @version v1.4*/
  public class BankDaoImpl implements BankDaoInterface
  {
      private static Properties props;
      public static Properties properties=new Properties();
      MoneyBean m1 = MoneyBean.getMoneyBean();
      UserBean userBean = UserBean.getUserBean();
      private static BankDaoImpl bankDaoImpl;

      //静态代码块，给静态变量初始化
   static
      {
          try
          {
              props = new Properties();
              File f=new File(".\\Bank.properties");
              FileInputStream in = new FileInputStream(f);
              props.load(in);
              in.close();
          }
          catch(IOException e)
          {
              e.printStackTrace();
          }

      }

      private BankDaoImpl(){

      }

      public static Properties getProps() {
          return props;
      }

      public static BankDaoImpl getBankDaoImpl() {
          if (bankDaoImpl == null) {
              bankDaoImpl = new BankDaoImpl();
          }
          return bankDaoImpl;
      }

      /**
       * 将MoneyBean的账户余额存储到该用户的properties文件中
       */
      @Override
      public void AddBank() {
          props.setProperty("money",String.valueOf(m1.getMoney()));
          try{
              FileOutputStream out = new
                      FileOutputStream(".\\"+userBean.getName()+".properties");
              props.store(out, "");
              out.close();
          }
          catch(IOException e)
          {
              System.out.println(e);
          }
      }

      /*实现注册功能
      * */
      @Override
      public void register(String _uname,String _upwd) throws IOException {
          props.setProperty("uname",_uname);
          props.setProperty("upwd",_upwd);
          props.setProperty("money","10.0");

          FileOutputStream out = new FileOutputStream(".\\"+_uname+".properties");
          props.store(out,"");
          out.close();
      }
      /*
      * 实现登录功能
      * */
      @Override
      public void login(String _uname,String _upwd) throws IOException {
              File f0=new File(".\\"+_uname+".properties");
              FileInputStream input = new FileInputStream(f0);
              props.load(input);
              input.close();

      }

    /**
     * 转账功能实现
     * @param others
     * @param money
     * @return 转账成功返回true,转账失败返回false
     */
      @Override
      public void transfer(String others,String money) throws IOException  {
          //读取要转账对象的文件

          File f0=new File(".\\"+others+".properties");
          FileInputStream input = new FileInputStream(f0);
          properties.load(input);
          input.close();

          m1.setMoney(m1.getMoney()-Double.parseDouble(money));

          //改变转账对象的数据
          String money0=String.valueOf(Double.parseDouble(properties.getProperty("money"))+Double.parseDouble(money));
          properties.setProperty("money",money0);
          FileOutputStream out = new FileOutputStream(".\\"+others+".properties");
          properties.store(out,".\\"+others+".properties");
          out.close();

      }
  }
