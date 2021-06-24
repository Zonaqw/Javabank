
 package com.cx.bank.manager;

 import com.cx.bank.model.MoneyBean;

 import java.util.Scanner;

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

    MoneyBean m1 = MoneyBean.getMoneyBean();

    /*
    * �˳�ϵͳ
    * */
    public void exitSystem(){ System.exit(0); }

    /*��ѯ�����˻��е�money���в�ѯ����
    * @return �������
    * */
    public double inquiry(){ return m1.getMoney(); }

    /*��������ȡǮ
     *@param qumoney
     *@return ����boolean���͵�flag,�����ȡ��Ǯ������true,������ܣ�����false
     */
    public boolean withdrawals(double qumoney){
            boolean flag=true;
            if(qumoney>inquiry()){
                System.out.println("����");
                flag=false;
            }else if(qumoney<0){
                flag = false;
            }
            m1.setMoney(m1.getMoney() - qumoney);
            return flag;
        }
    /*
    * ���������Ǯ
    * @param cunmoney
    * @return ����boolean���͵�flagֵ������ܴ浽Ǯ���򷵻�true��������ܴ浽Ǯ���򷵻�false
    * */
    public boolean deposit(double cunmoney){
        boolean flag = true;
        if(cunmoney < 0) {
            flag = false;
        }
        m1.setMoney(m1.getMoney() + cunmoney);
        return flag;
    }
 }