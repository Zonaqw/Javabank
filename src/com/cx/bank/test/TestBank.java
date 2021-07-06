
	 package com.cx.bank.test;

	 import com.cx.bank.manager.ManagerImpl;
	 import com.cx.bank.util.AccountOverDrawnException;
	 import com.cx.bank.util.InvalidDepositException;
	 import com.cx.bank.util.MD5;

	 import java.io.IOException;
	 import java.util.Scanner;

	 public class TestBank{
	   public static void main(String[] args) {
		   ManagerImpl managerImpl=ManagerImpl.getInstance();
		   while (true) {
		   register0();
	        Scanner sc = new Scanner(System.in);
	        String i=sc.next();
		        if (i.equals("1")) {
			        System.out.print("用户名：");
			        String uname = sc.next();
			        System.out.print("密码：");
			        String upwd = sc.next();
			        try {
				        boolean flag = managerImpl.register(uname, upwd);

				        if (!flag) System.out.println("注册失败");
				        else System.out.println("注册成功");

			        } catch (IOException e) {
				        System.out.println(e);
			        }
		        } else if (i.equals("2")) {
			        try {
				        System.out.print("用户名：");
				        String name = sc.next();
				        System.out.print("密码：");
				        String pwd = sc.next();
				        MD5 md5 = new MD5();
				        String pwd0 = md5.getMD5(pwd);
				        boolean flag = managerImpl.login(name, pwd0);
				        if (flag) {
					        System.out.println("登录成功");
					        while (true) {

						        System.out.println("---------欢迎进入银行-------------");
						        System.out.println("----       1：查询余额  ----------");
						        System.out.println("----       2：取款      ----------");
						        System.out.println("----       3：存款      ----------");
						        System.out.println("----       4：转账      ----------");
						        System.out.println("----       5：退出      ----------");
						        System.out.println("--------------------------------");
						        Scanner scanner = new Scanner(System.in);
						        String a = scanner.next();

						        if (a.equals("1")) {
							        System.out.println("您的余额为：" + managerImpl.inquiry());

						        } else if (a.equals("2")) {
							        try {
								        System.out.print("请输入取款金额：");
								        String qumoney = scanner.next();
								        managerImpl.withdrawals(qumoney);
							        } catch (AccountOverDrawnException e) {
								        System.out.println("取款失败");
							        }
						        } else if (a.equals("3")) {
							        try {
								        System.out.println("请输入存款金额：");
								        String cunmoney = scanner.next();
								        managerImpl.deposit(cunmoney);
							        } catch (InvalidDepositException e) {
								        System.out.println("存款失败");
							        }
						        } else if (a.equals("4")) {
							        try {
								        System.out.print("转账对象：");
								        String uname = scanner.next();
								        System.out.print("转账金额");
								        String zmoney = scanner.next();
								        managerImpl.transfer(uname, zmoney);
							        } catch (IOException e) {
								        System.out.println(e.getMessage());
							        }
						        } else if (a.equals("5")) {
							        try {
								        managerImpl.exitSystem();
							        } catch (IOException e) {
								        System.out.println(e.getMessage());
							        }
						        }
					        }
				        } else System.out.println("登录失败");
			        } catch (IOException e) {
				        System.out.println(e.getMessage());
			        }
		        } else if (i.equals("3")) {
			        System.out.println("欢迎下次光临");
			        System.exit(0);
		        }
	        }
	 }
	 public static void register0(){
		  System.out.println("---------欢迎进入银行-------------");
		  System.out.println("----       1：注册      ----------");
		  System.out.println("----       2：登录      ----------");
		  System.out.println("----       3：退出      ----------");
		  System.out.println("--------------------------------");
	 }
	/* public static void login0() {
		 while (true) {

		 	 System.out.println("---------欢迎进入银行-------------");
			 System.out.println("----       1：查询余额  ----------");
			 System.out.println("----       2：取款      ----------");
			 System.out.println("----       3：存款      ----------");
			 System.out.println("----       4：转账      ----------");
			 System.out.println("----       5：退出      ----------");
			 System.out.println("--------------------------------");
			 ManagerImpl managerImpl = ManagerImpl.getInstance();

			 Scanner scanner = new Scanner(System.in);
			 String i = scanner.next();

			 if (i.equals("1")) {
				 System.out.print("您的余额为：" + managerImpl.inquiry());

			 } else if (i.equals("2")) {
				 try {
					 System.out.print("请输入取款金额：");
					 String qumoney = scanner.next();
					 managerImpl.withdrawals(qumoney);
				 } catch (AccountOverDrawnException e) {
					 System.out.println("取款失败");
				 }
			 } else if (i.equals("3")) {
				 try {
					 System.out.println("请输入存款金额：");
					 String cunmoney = scanner.next();
					 managerImpl.deposit(cunmoney);
				 } catch (InvalidDepositException e) {
					 System.out.println("存款失败");
				 }
			 } else if (i.equals("4")) {
				 try {
					 System.out.print("转账对象：");
					 String name = scanner.next();
					 System.out.print("转账金额");
					 String zmoney = scanner.next();
					 managerImpl.transfer(name, zmoney);
				 } catch (IOException e) {
					 System.out.println(e.getMessage());
				 }
			 } else if (i.equals("5")) {
				 try {
					 managerImpl.exitSystem();
				 } catch (IOException e) {
					 System.out.println(e.getMessage());
				 }
			 }
		 }
	 }*/
 }