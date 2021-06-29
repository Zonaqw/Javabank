
 package com.cx.bank.manager;

 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.model.UserBean;
 import com.cx.bank.util.*;

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Properties;
 import java.util.Scanner;

 import static com.cx.bank.dao.BankDaoImpl.properties;

 /*@projectName Javabank
 * @package com.cx.bank.manager
 * @className ManagerImpl
 * @description ����ʵ�ָ��ֹ���ģ��
 * @version v1.4
 * */
 public class ManagerImpl implements Manager{
    private static ManagerImpl managerimpl;

    Scanner in = new Scanner(System.in);
    private ManagerImpl(){}
    public static ManagerImpl getManagerImpl() {
        if (managerimpl == null) {
            managerimpl = new ManagerImpl();
        }
        return managerimpl;
    }

     /**��������
      * MoneyBean������ʱ�洢money
      * BankDaoImpl���󣬴洢����ȡ����
      * props���󣬽���ȡ��������ʱ�洢
      */
    UserBean userBean=UserBean.getUserBean();
    MoneyBean m1 = MoneyBean.getMoneyBean();
    BankDaoImpl b1 = BankDaoImpl.getBankDaoImpl();
    Properties props = BankDaoImpl.getProps();

    /*
    * �˳�ϵͳ
    * */
    public void exitSystem(){
      b1.AddBank();
      System.out.println("�˳��ɹ�");
      System.exit(1); }

    /*��ѯ�����˻��е�money���в�ѯ����
    * @return �������
    * */
    public double inquiry(){ return m1.getMoney(); }

    /*��������ȡǮ
     *@param qumoney
     */
    public void withdrawals(Double qumoney) throws AccountOverDrawnException {
            if(qumoney>inquiry()){
                throw new AccountOverDrawnException("����");
            }
            else if(qumoney<0){
                throw new AccountOverDrawnException("ȡǮ����ȡ����");
            }
            m1.setMoney(m1.getMoney() - qumoney);
        }
    /*
    * ���������Ǯ
    * @param cunmoney
    * */
    public void deposit(Double cunmoney) throws InvalidDepositException {
        if(cunmoney < 0) {
        throw new InvalidDepositException("��Ǯ���ܴ渺��");
        }
    m1.setMoney(m1.getMoney() + cunmoney);
    }

  /**
   * �û�ע��
   * @param _uname
   * @param _upwd
   * @return flag
   */
     @Override
     public void register(String _uname,String _upwd) throws RegisterException, IOException {

            //�û��������벻��Ϊ��
            if(_uname==null||_upwd==null){
              throw new RegisterException("�û��������벻��Ϊ��");
            }

            //�û������벻���Ѿ�����
            File dir = new File(".\\"+_uname+".properties");
            if (dir.exists()){

              throw new RegisterException("�û��Ѿ�����");
            }

            //���û���������д���ļ���

              b1.register(_uname, _upwd);

     }

  /**
   * �û���¼
   * @param  _uname
   * @param  _upwd
   * @return flag
   */
     @Override
     public void login(String _uname,String _upwd) throws LoginException, IOException {
        //�û��������벻��Ϊ��
        if (_uname == null || _upwd == null) {
           throw new LoginException("�û��������벻��Ϊ��");
        }
        //�û��������벻�ܲ�����
         File dir = new File(".\\"+_uname+".properties");
         if (!dir.exists()){
           throw new LoginException("�û�������");
         }

        //��ȡ���洢����
         b1.login(_uname, _upwd);
        //�ж�������û����������Ƿ���ȷ�����������ʾ��¼ʧ��
        if(_uname.equals(props.getProperty("uname"))&&_upwd.equals(props.getProperty("upwd"))){
          userBean.setName(props.getProperty("uname"));
          userBean.setPassword(props.getProperty("upwd"));
          m1.setMoney(Double.parseDouble(props.getProperty("money")));
        }else {
          throw new LoginException("�û������������");
        }

     }

   /**
    *
    * @param others
    * @param money
    * @return
    */
  @Override
  public  void transfer(String others, String money) throws IOException, TransferException {

    File file = new File(".//"+others+".properties");
    if (!file.exists()){
      throw new TransferException("û������û�");
    }
    if(Double.parseDouble(money)>m1.getMoney()) {
      throw new TransferException("����");
    }
    if(Double.parseDouble(money)<0){
      throw new TransferException("����Ϊ����");
    }
    b1.transfer(others, money);
    if(properties.getProperty("uname").equals(userBean.getName())){
      throw new TransferException("���ܸ��Լ�ת��");
    }


  }
}