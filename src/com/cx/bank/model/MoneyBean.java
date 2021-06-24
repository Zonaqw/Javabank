
 package com.cx.bank.model;
 public class MoneyBean{
    private double money;
    private static  MoneyBean moneyBean ; //单例
    private MoneyBean(){}
    //改变money的值
    public void setMoney(double _money) { this.money = _money; }
    //获取money的值
    public double getMoney() { return money; }
    //获取变量moneyBean
    public static MoneyBean getMoneyBean() {
        if(moneyBean==null) {
            moneyBean = new MoneyBean();
        }
        return moneyBean;
    }
 }