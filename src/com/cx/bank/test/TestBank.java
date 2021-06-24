
 package com.cx.bank.test;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 import java.util.Scanner;

 public class TestBank{
    public static void main(String[] args) {
        ManagerImpl manager = ManagerImpl.getManagerImpl();
        MoneyBean m2 = MoneyBean.getMoneyBean();
        Scanner in = new Scanner(System.in);
        System.out.println("·········  欢迎进入银行   ·········");
        while (true) {
            System.out.println("····     您可执行如下操作   ········");
            System.out.println("··· 1:查询 2:取款 3:存款 4:退出·····");
            System.out.println("··································");
            String a = in.next();
            if("1".equals(a)){
                System.out.println("您的余额为:"+manager.inquiry());
            }else if ("2".equals(a)){
                try {
                    System.out.println("请问您想取多少钱？");
                    String money = in.next();//输入取款金额
                    Double qumoney = Double.parseDouble(money);
                    manager.withdrawals(qumoney);//调用取款方法withdrawals()
                    System.out.println("取款成功，您的余额为:"+manager.inquiry());
                }catch (AccountOverDrawnException e) {
                    System.out.println("warning"+e.getMessage());
                   // e.printStackTrace();
                }
            }else if ("3".equals(a)){
                try {
                    System.out.println("请问您想存多少钱？");
                    String money = in.next();//输入存款金额
                    Double cunmoney = Double.parseDouble(money);
                    manager.deposit(cunmoney);//调用存款方法deposit()
                    System.out.println("存款成功，您的余额为:"+manager.inquiry());
                }catch (InvalidDepositException e){
                    System.out.println("warning"+e.getMessage());
                   // e.printStackTrace();
                }
            }else if ("4".equals(a)){
                System.out.println("退出成功，欢迎下次光临");
                manager.exitSystem();
            }
        }
    }

 }



