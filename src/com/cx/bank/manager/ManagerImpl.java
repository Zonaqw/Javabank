
 package com.cx.bank.manager;

 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 import java.util.Scanner;
 /*
 *ʵ�ֽӿ�Manager��ķ���
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
    * �˳�ϵͳ
    * */
    public void exitSystem(){ System.exit(0); }

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
 }