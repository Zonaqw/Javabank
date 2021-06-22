
 package com.cx.bank.test;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
 import java.util.Scanner;

 public class TestBank{
    public static void main(String[] args) {
        ManagerImpl manager = ManagerImpl.getManagerImpl();
        MoneyBean m2 = MoneyBean.getMoneyBean();
        System.out.println("欢迎进入银行");
        Scanner in = new Scanner(System.in);
               while (true) {
                 System.out.println("请选择服务");
                    System.out.println("0:退出系统   1：查询   2：取款   3：存款");
                    int a = in.nextInt();
                    switch (a) {
                        //退出系统
                        case 0: {
                            System.out.println("退出成功，欢迎下次光临");
                            manager.exitSystem();
                        }
                        //查询余额
                        case 1: {
                            System.out.println("您的余额为：" + manager.inquiry());
                        }
                        break;
                        //取款
                        case 2: {
                            System.out.println("取钱金额为：");
                            double qumoney = in.nextDouble();
                            while (qumoney > m2.getMoney()) {
                                System.out.print("余额不足，请重新输入：");
                                qumoney = in.nextDouble();
                            }
                            if (qumoney<0){
                                System.out.println("操作异常，请重新输入：");
                                 break;
                            }
                            System.out.println("取款成功， 您的余额为：" + manager.withdrawals(qumoney));
                        }
                        break;
                        //存款
                        case 3: {
                            System.out.println("存钱金额为：");
                            double cunmoney = in.nextDouble();
                            while (cunmoney < 0) {
                                System.out.print("存的钱不能是负数，请重新输入：");
                                cunmoney = in.nextDouble();
                            }
                            System.out.println("存款成功， 您的余额为：" + manager.deposit(cunmoney));
                        }
                        break;
                        default :{
                            System.out.println("操作有误，请重试");
                        }break ;
                    }
               }

    }

 }



