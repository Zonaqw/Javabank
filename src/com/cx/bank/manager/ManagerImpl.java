
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
    * 退出系统
    * */
    public void exitSystem(){ System.exit(0); }

    /*查询余额，对账户中的money进行查询操作
    * @return 返回余额
    * */
    public double inquiry(){ return m1.getMoney(); }

    /*从银行里取钱
     *@param qumoney
     *@return 返回boolean类型的flag,如果能取到钱，返回true,如果不能，返回false
     */
    public boolean withdrawals(double qumoney){
            boolean flag=true;
            if(qumoney>inquiry()){
                System.out.println("余额不足");
                flag=false;
            }else if(qumoney<0){
                flag = false;
            }
            m1.setMoney(m1.getMoney() - qumoney);
            return flag;
        }
    /*
    * 从银行里存钱
    * @param cunmoney
    * @return 返回boolean类型的flag值，如果能存到钱，则返回true，如果不能存到钱，则返回false
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