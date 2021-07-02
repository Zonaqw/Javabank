
  package com.cx.bank.dao;


  import com.cx.bank.util.MD5;

  import java.io.*;
  import java.util.Properties;

  import static com.cx.bank.manager.ManagerImpl.m1;
  import static com.cx.bank.manager.ManagerImpl.userBean;

  /*@projectName Javabank
  * @package com.cx.bank.dao
  * @className BankDaoImpl
  * @description ����ʵ�ָ��ֹ���ģ������ݴ洢
  * @version v1.4*/
  public class BankDaoImpl implements BankDaoInterface
  {
      private static Properties props;
      public static Properties properties;
      private static BankDaoImpl bankDaoImpl;

      private BankDaoImpl() {

      }
      public static BankDaoImpl getBankDaoImpl() {
          if(bankDaoImpl == null)
              bankDaoImpl=new BankDaoImpl();
          return bankDaoImpl;
      }
      //��̬����飬����̬������ʼ��
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


      public static Properties getProps() {
          return props;
      }

      /**
       * ��MoneyBean���˻����洢�����û���properties�ļ���
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

      /*ʵ��ע�Ṧ��
      * */
      @Override
      public void register(String _uname,String _upwd) throws IOException {
          MD5 md5=new MD5();
          props.setProperty("uname",_uname);
          props.setProperty("upwd", md5.getMD5(_upwd));
          props.setProperty("money","10.0");

          FileOutputStream out = new FileOutputStream(".\\"+_uname+".properties");
          props.store(out,"");
          out.close();
      }
      /*
      * ʵ�ֵ�¼����
      * */
      @Override
      public void login(String _uname,String _upwd) throws IOException {
              File f0=new File(".\\"+_uname+".properties");
              FileInputStream input = new FileInputStream(f0);
              props.load(input);
              input.close();
      }
    /**
     * ת�˹���ʵ��
     * @param others
     * @param money
     */
      @Override
      public void transfer(String others,String money) throws IOException  {
          //��ȡҪת�˶�����ļ�
          properties=new Properties();
          File f0=new File(".\\"+others+".properties");
          FileInputStream input = new FileInputStream(f0);
          properties.load(input);
          input.close();

          m1.setMoney(m1.getMoney()-Double.parseDouble(money));

          //�ı�ת�˶��������
          String money0=String.valueOf(Double.parseDouble(properties.getProperty("money"))+Double.parseDouble(money));
          properties.setProperty("money",money0);
          FileOutputStream out = new FileOutputStream(".\\"+others+".properties");
          properties.store(out,".\\"+others+".properties");
          out.close();

      }
  }
