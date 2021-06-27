
  package com.cx.bank.dao;

  import com.cx.bank.model.MoneyBean;
  import com.cx.bank.model.UserBean;

  import java.io.File;
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  import java.util.Properties;

  /*@projectName Javabank
  * @package com.cx.bank.dao
  * @className BankDaoImpl
  * @description ����ʵ�ָ��ֹ���ģ������ݴ洢
  * @version v1.4*/
  public class BankDaoImpl implements BankDaoInterface
  {
      private static Properties props;
      MoneyBean m1 = MoneyBean.getMoneyBean();
      UserBean userBean = UserBean.getUserBean();
      private static BankDaoImpl bankDaoImpl;

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
      //����ֵ
      private BankDaoImpl(){
          m1.setMoney(Double.parseDouble(props.getProperty("money")));
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
       * ��MoneyBean���˻����洢�����û���properties�ļ���
       */
      @Override
      public void AddBank() {
          props.setProperty("money",String.valueOf(m1.getMoney()));
          try{
              FileOutputStream out = new
                      FileOutputStream(".\\"+userBean.getName()+".properties");
              props.store(out, ".\\"+userBean.getName() + ".properties");
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
          props.setProperty("uname",_uname);
          props.setProperty("upwd",_upwd);
          props.setProperty("money","10.0");

          FileOutputStream out = new FileOutputStream(".\\"+_uname+".properties");
          props.store(out,".\\"+_uname+".properties");
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
              userBean.setName(props.getProperty("uname"));
              userBean.setPassword(props.getProperty("upwd"));
              m1.setMoney(Double.parseDouble(props.getProperty("money")));
      }

    /**
     * ת�˹���ʵ��
     * @param others
     * @param money
     * @return ת�˳ɹ�����true,ת��ʧ�ܷ���false
     */
      @Override
      public boolean transfer(String others,String money)  {
        try {
          if(Double.parseDouble(money)>m1.getMoney()||Double.parseDouble(money)<0) return false;
          //��ȡҪת�˶�����ļ�
          Properties properties=new Properties();
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

        } catch (IOException | NumberFormatException e) {
          e.printStackTrace();
        }
        return true;
      }
  }
