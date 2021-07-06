
 package com.cx.bank.model;

/**
 * @projectName Javabank
 * @package com.cx.bank.model
 * @className MoneyBean
 * @description 用于封装余额数据
 * @version v1.4
 * */
 public class MoneyBean{

    private double money;

    public MoneyBean(){}
    //改变money的值
    public void setMoney(double _money) { this.money = _money; }
    //获取money的值
    public double getMoney() { return money; }

 }