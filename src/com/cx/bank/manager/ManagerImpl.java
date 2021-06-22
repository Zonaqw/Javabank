
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
    //退出系统
    public void exitSystem(){
        System.exit(0);
    }
    //查询
    public double inquiry(){
        return m1.getMoney();
    }
    //取款
    public double withdrawals(double _money){

            m1.setMoney(m1.getMoney() - _money);

            return m1.getMoney();
        }

    //存款
    public double deposit(double _money){

        m1.setMoney(m1.getMoney() + _money);

        return m1.getMoney();
    }
 }