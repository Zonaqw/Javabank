
 package com.cx.bank.model;
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