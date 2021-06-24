
 package com.cx.bank.test;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
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
                    int a = in.nextInt();
                    switch (a) {
                        //查询余额
                        case 1: {
                            System.out.println("您的余额为：" + manager.inquiry());
                        }
                        break;
                        //取款
                        case 2: {
                            System.out.println("您想取多少钱？");
                            double qumoney = in.nextDouble();
                            boolean flag=  manager.withdrawals(qumoney);
                            if(flag) {
                                System.out.println("取款成功，您的余额为：" + manager.inquiry());
                            }else {
                                System.out.println("取款失败");
                            }
                        }
                        break;
                        //存款
                        case 3: {
                            System.out.println("您想存多少钱？");
                            double cunmoney = in.nextDouble();
                            boolean flag = manager.deposit(cunmoney);
                            if (flag) {
                                System.out.println("存款成功，您的余额为：" + manager.inquiry());
                            }else {
                                System.out.println("存款失败");
                            }
                        }
                        break;
                        //退出系统
                        case 4: {
                            System.out.println("退出成功，欢迎下次光临");
                            manager.exitSystem();
                        }
                        default :{
                            System.out.println("操作有误，请重试");
                        }break ;
                    }
               }

    }

 }



