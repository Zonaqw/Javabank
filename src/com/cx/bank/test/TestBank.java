
 package com.cx.bank.test;
 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 import java.util.Scanner;

 public class TestBank {

     //注册界面
     public static void register0() {
         System.out.println("·········  欢迎进入银行   ········");
         System.out.println("          您可执行如下操作        ");
         System.out.println("              1:注册             ");
         System.out.println("              2:登录             ");
         System.out.println("              3:退出系统          ");
         System.out.println("·································");
     }
     //登录界面
     public static void loginin() {
         System.out.println("------   您可执行以下操作------------");
         System.out.println("           1:查询余额               ");
         System.out.println("           2:取款                   ");
         System.out.println("           3:存款                   ");
         System.out.println("           4:转账                   ");
         System.out.println("           5:退出系统                ");
         System.out.println("------------------------------------");
     }

     public static void main(String[] args) {
         ManagerImpl manager = ManagerImpl.getManagerImpl();
         MoneyBean m2 = MoneyBean.getMoneyBean();
         BankDaoImpl bankDaoImpl = BankDaoImpl.getBankDaoImpl();
         Scanner in = new Scanner(System.in);

         while (true) {
             register0();
             String i = in.next();

             if ("1".equals(i)) {
                 System.out.println("用户名");
                 String uname = in.next();
                 System.out.println("密码");
                 String upwd = in.next();

                 if(manager.register(uname, upwd))
                     System.out.println("注册成功");
                 else
                     System.out.println("注册失败");
                 } else if ("2".equals(i)) {

                 System.out.println("请输入用户名");
                 String uname=in.next();
                 System.out.println("请输入密码");
                 String upwd = in.next();

                 //判断用户名或密码是否正确,若正确，进入登录页面
                 if(manager.login(uname, upwd)){
                     System.out.println("登录成功");
                 while(true) {
                     /*
                       登录成功，进入登录页面
                      */
                     loginin();
                         String a = in.next();
                         if ("1".equals(a)){
                             System.out.println("您的余额为:"+String.valueOf(manager.inquiry()));
                         }else if ("2".equals(a)){
                             try {
                                 System.out.println("您想取多少钱？");
                                 String qumoney = in.next();
                                 manager.withdrawals(Double.parseDouble(qumoney));
                                 System.out.println("取款成功，您的余额为："+String.valueOf(manager.inquiry()));
                             }catch (AccountOverDrawnException e){
                                 System.out.println("warning:"+e.getMessage());
                             }
                         }else if("3".equals(a)){
                             try {
                                 System.out.println("您想存多少钱？");
                                 String cunmoney = in.next();
                                 manager.deposit(Double.parseDouble(cunmoney));
                                 System.out.println("存款成功，您的余额为："+String.valueOf(manager.inquiry()));
                             }catch (InvalidDepositException e){
                                 System.out.println("warning:"+e.getMessage());
                             }
                         }else if ("4".equals(a)){
                             System.out.println("请输入您想转账的对象");
                             String others = in.next();
                             System.out.println("请输入转账金额");
                             String zhuanmoney=in.next();
                             if(bankDaoImpl.transfer(others,zhuanmoney)) {
                                 System.out.println("转账成功");
                             }else System.out.println("转账失败，请检查是否输入有误");
                         } else if ("5".equals(a)){
                             manager.exitSystem();
                         }

                     }
                 } System.out.println("登录失败，用户名或密码错误");
                 }else if("3".equals(i)){
                 manager.exitSystem();
             }

             }
         }

     }