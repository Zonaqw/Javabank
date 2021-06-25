
 package com.cx.bank.manager;

 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 import java.util.Scanner;
 /*
 *实现接口Manager里的方法
 */
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
     */
    public void withdrawals(Double qumoney) throws AccountOverDrawnException {
            if(qumoney>inquiry()){
                throw new AccountOverDrawnException("余额不足");
            }
            else if(qumoney<0){
                throw new AccountOverDrawnException("取钱不能取负的");
            }
            m1.setMoney(m1.getMoney() - qumoney);
        }
    /*
    * 从银行里存钱
    * @param cunmoney
    * */
    public void deposit(Double cunmoney) throws InvalidDepositException {
        if(cunmoney < 0) {
        throw new InvalidDepositException("存钱不能存负的");
        }
    m1.setMoney(m1.getMoney() + cunmoney);
    }
 }