
 package com.cx.bank.test;
 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.model.UserBean;
 import com.cx.bank.util.*;


 import java.io.IOException;
 import java.util.Scanner;

 public class TestBank {
     public static void main(String[] args) {
         while (true) {
             register0();
             ManagerImpl manager = ManagerImpl.getManagerImpl();
             Scanner in = new Scanner(System.in);
             String i = in.next();
             if ("1".equals(i)) {
                 System.out.println("�û���");
                 String uname = in.next();
                 System.out.println("����");
                 String upwd = in.next();
                try {
                   manager.register(uname,upwd);
                        System.out.println("ע��ɹ�");

                }catch (RegisterException|IOException e){
                    System.out.println(e.getMessage());
                    System.out.println("ע��ʧ��");
                }

             } else if ("2".equals(i)) {

                 System.out.println("�������û���");
                 String uname = in.next();
                 System.out.println("����������");
                 String upwd = in.next();

                 //�ж��û����������Ƿ���ȷ,����ȷ�������¼ҳ��
                 try {
                     manager.login(uname, upwd);
                     System.out.println("��¼�ɹ�");
                     while(true) {
                         /*
                           ��¼�ɹ��������¼ҳ��
                          */
                         loginin();
                         String a = in.next();
                         if ("1".equals(a)){
                             System.out.println("�������Ϊ:"+manager.inquiry());
                         }else if ("2".equals(a)){
                             try {
                                 System.out.println("����ȡ����Ǯ��");
                                 String qumoney = in.next();
                                 manager.withdrawals(Double.parseDouble(qumoney));
                                 System.out.println("ȡ��ɹ����������Ϊ��"+manager.inquiry());
                             }catch (AccountOverDrawnException e){
                                 System.out.println("warning:"+e.getMessage());
                             }
                         }else if("3".equals(a)){
                             try {
                                 System.out.println("��������Ǯ��");
                                 String cunmoney = in.next();
                                 manager.deposit(Double.parseDouble(cunmoney));
                                 System.out.println("���ɹ����������Ϊ��"+manager.inquiry());
                             }catch (InvalidDepositException e){
                                 System.out.println("warning:"+e.getMessage());
                             }
                         }else if ("4".equals(a)) {
                             System.out.println("����������ת�˵Ķ���");
                             String others = in.next();
                             System.out.println("������ת�˽��");
                             String zhuanmoney = in.next();
                             try {
                                 manager.transfer(others,zhuanmoney);
                                 System.out.println("ת�˳ɹ�");

                             }catch (IOException e) {
                                 System.out.println("û������û�");
                                 System.out.println("ת��ʧ��");
                             }catch (TransferException ex){
                                 System.out.println(ex.getMessage());
                                 System.out.println("ת��ʧ��");
                             }
                         } else if ("5".equals(a)){
                             manager.exitSystem();
                         }
                     }
                 } catch (LoginException | IOException e) {
                     System.out.println(e.getMessage());
                     System.out.println("��¼ʧ��");
                 }

             } else if ("3".equals(i)) {
                 manager.exitSystem();
             }

         }
     }

     //ע�����
     public static void register0() {
         System.out.println("������������������  ��ӭ��������   ����������������");
         System.out.println("          ����ִ�����²���        ");
         System.out.println("              1:ע��             ");
         System.out.println("              2:��¼             ");
         System.out.println("              3:�˳�ϵͳ          ");
         System.out.println("������������������������������������������������������������������");
     }
     //��¼����
     public static void loginin() {
         System.out.println("------   ����ִ�����²���------------");
         System.out.println("           1:��ѯ���               ");
         System.out.println("           2:ȡ��                   ");
         System.out.println("           3:���                   ");
         System.out.println("           4:ת��                   ");
         System.out.println("           5:�˳�ϵͳ                ");
         System.out.println("------------------------------------");
     }
 }

