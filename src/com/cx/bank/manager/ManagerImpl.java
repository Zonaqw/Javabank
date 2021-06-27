
 package com.cx.bank.manager;

 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.model.UserBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 import java.io.File;
 import java.io.FileInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Properties;
 import java.util.Scanner;

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
     public boolean register(String _uname,String _upwd)  {

            boolean flag = true;

            //�û��������벻��Ϊ��
            if(_uname==null||_upwd==null) return false;

            //�û������벻���Ѿ�����
            File dir = new File(".\\"+_uname+".properties");
            if (dir.exists()) flag=false;

            //���û���������д���ļ���
            try {
              if(flag) b1.register(_uname, _upwd);
            }catch (IOException e){
              System.out.println(e);
            }


            return flag;
     }

  /**
   * �û���¼
   * @param  _uname
   * @param  _upwd
   * @return flag
   */
     @Override
     public boolean login(String _uname,String _upwd) {

        boolean flag = true;

        //�û��������벻��Ϊ��
        if (_uname == null || _upwd == null)  return false;

        //�û��������벻�ܲ�����
         File dir = new File(".\\"+_uname+".properties");
         if (!dir.exists()) flag=false;

        //��ȡ���洢����
       try {
         b1.login(_uname, _upwd);
       }catch (IOException e) {
         System.out.println("û������û����������û����Ƿ�������ȷ");
         flag = false;
       }
        //�ж�������û����������Ƿ���ȷ�����������ʾ��¼ʧ��
        if(_uname.equals(props.getProperty("uname"))&&_upwd.equals(props.getProperty("upwd"))){
            flag = true;
        }else {
          flag = false;
        }
        return flag;
     }
 }