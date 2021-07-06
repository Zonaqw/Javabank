
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
			        System.out.print("�û�����");
			        String uname = sc.next();
			        System.out.print("���룺");
			        String upwd = sc.next();
			        try {
				        boolean flag = managerImpl.register(uname, upwd);

				        if (!flag) System.out.println("ע��ʧ��");
				        else System.out.println("ע��ɹ�");

			        } catch (IOException e) {
				        System.out.println(e);
			        }
		        } else if (i.equals("2")) {
			        try {
				        System.out.print("�û�����");
				        String name = sc.next();
				        System.out.print("���룺");
				        String pwd = sc.next();
				        MD5 md5 = new MD5();
				        String pwd0 = md5.getMD5(pwd);
				        boolean flag = managerImpl.login(name, pwd0);
				        if (flag) {
					        System.out.println("��¼�ɹ�");
					        while (true) {

						        System.out.println("---------��ӭ��������-------------");
						        System.out.println("----       1����ѯ���  ----------");
						        System.out.println("----       2��ȡ��      ----------");
						        System.out.println("----       3�����      ----------");
						        System.out.println("----       4��ת��      ----------");
						        System.out.println("----       5���˳�      ----------");
						        System.out.println("--------------------------------");
						        Scanner scanner = new Scanner(System.in);
						        String a = scanner.next();

						        if (a.equals("1")) {
							        System.out.println("�������Ϊ��" + managerImpl.inquiry());

						        } else if (a.equals("2")) {
							        try {
								        System.out.print("������ȡ���");
								        String qumoney = scanner.next();
								        managerImpl.withdrawals(qumoney);
							        } catch (AccountOverDrawnException e) {
								        System.out.println("ȡ��ʧ��");
							        }
						        } else if (a.equals("3")) {
							        try {
								        System.out.println("���������");
								        String cunmoney = scanner.next();
								        managerImpl.deposit(cunmoney);
							        } catch (InvalidDepositException e) {
								        System.out.println("���ʧ��");
							        }
						        } else if (a.equals("4")) {
							        try {
								        System.out.print("ת�˶���");
								        String uname = scanner.next();
								        System.out.print("ת�˽��");
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
				        } else System.out.println("��¼ʧ��");
			        } catch (IOException e) {
				        System.out.println(e.getMessage());
			        }
		        } else if (i.equals("3")) {
			        System.out.println("��ӭ�´ι���");
			        System.exit(0);
		        }
	        }
	 }
	 public static void register0(){
		  System.out.println("---------��ӭ��������-------------");
		  System.out.println("----       1��ע��      ----------");
		  System.out.println("----       2����¼      ----------");
		  System.out.println("----       3���˳�      ----------");
		  System.out.println("--------------------------------");
	 }
	/* public static void login0() {
		 while (true) {

		 	 System.out.println("---------��ӭ��������-------------");
			 System.out.println("----       1����ѯ���  ----------");
			 System.out.println("----       2��ȡ��      ----------");
			 System.out.println("----       3�����      ----------");
			 System.out.println("----       4��ת��      ----------");
			 System.out.println("----       5���˳�      ----------");
			 System.out.println("--------------------------------");
			 ManagerImpl managerImpl = ManagerImpl.getInstance();

			 Scanner scanner = new Scanner(System.in);
			 String i = scanner.next();

			 if (i.equals("1")) {
				 System.out.print("�������Ϊ��" + managerImpl.inquiry());

			 } else if (i.equals("2")) {
				 try {
					 System.out.print("������ȡ���");
					 String qumoney = scanner.next();
					 managerImpl.withdrawals(qumoney);
				 } catch (AccountOverDrawnException e) {
					 System.out.println("ȡ��ʧ��");
				 }
			 } else if (i.equals("3")) {
				 try {
					 System.out.println("���������");
					 String cunmoney = scanner.next();
					 managerImpl.deposit(cunmoney);
				 } catch (InvalidDepositException e) {
					 System.out.println("���ʧ��");
				 }
			 } else if (i.equals("4")) {
				 try {
					 System.out.print("ת�˶���");
					 String name = scanner.next();
					 System.out.print("ת�˽��");
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