
 package com.cx.bank.model;

/*@projectName Javabank
 * @package com.cx.bank.model
 * @className MoneyBean
 * @description ���ڷ�װ�������
 * @version v1.4
 * */
 public class MoneyBean{
    private double money;
    private static  MoneyBean moneyBean ; //����
    private MoneyBean(){}
    //�ı�money��ֵ
    public void setMoney(double _money) { this.money = _money; }
    //��ȡmoney��ֵ
    public double getMoney() { return money; }
    //��ȡ����moneyBean
    public static MoneyBean getMoneyBean() {
        if(moneyBean==null) {
            moneyBean = new MoneyBean();
        }
        return moneyBean;
    }
 }