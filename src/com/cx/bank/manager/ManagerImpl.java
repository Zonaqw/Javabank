
 package com.cx.bank.manager;

 import com.cx.bank.model.MoneyBean;

 public class ManagerImpl implements Manager{
    private static ManagerImpl managerimpl;
    private ManagerImpl(){

    }

    public static ManagerImpl getManagerImpl() {
        if (managerimpl == null) {
            managerimpl = new ManagerImpl();
        }
        return managerimpl;
    }

    MoneyBean m1 = MoneyBean.getMoneyBean();
    //�˳�ϵͳ
    public void exitSystem(){
        System.exit(0);
    }
    //��ѯ
    public double inquiry(){
        return m1.getMoney();
    }
    //ȡ��
    public double withdrawals(double _money){

            m1.setMoney(m1.getMoney() - _money);

            return m1.getMoney();
        }

    //���
    public double deposit(double _money){

        m1.setMoney(m1.getMoney() + _money);

        return m1.getMoney();
    }
 }