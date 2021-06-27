
 package com.cx.bank.test;
 import com.cx.bank.dao.BankDaoImpl;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
 import com.cx.bank.util.AccountOverDrawnException;
 import com.cx.bank.util.InvalidDepositException;

 import java.util.Scanner;

 public class TestBank {

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

     public static void main(String[] args) {
         ManagerImpl manager = ManagerImpl.getManagerImpl();
         MoneyBean m2 = MoneyBean.getMoneyBean();
         BankDaoImpl bankDaoImpl = BankDaoImpl.getBankDaoImpl();
         Scanner in = new Scanner(System.in);

         while (true) {
             register0();
             String i = in.next();

             if ("1".equals(i)) {
                 System.out.println("�û���");
                 String uname = in.next();
                 System.out.println("����");
                 String upwd = in.next();

                 if(manager.register(uname, upwd))
                     System.out.println("ע��ɹ�");
                 else
                     System.out.println("ע��ʧ��");
                 } else if ("2".equals(i)) {

                 System.out.println("�������û���");
                 String uname=in.next();
                 System.out.println("����������");
                 String upwd = in.next();

                 //�ж��û����������Ƿ���ȷ,����ȷ�������¼ҳ��
                 if(manager.login(uname, upwd)){
                     System.out.println("��¼�ɹ�");
                 while(true) {
                     /*
                       ��¼�ɹ��������¼ҳ��
                      */
                     loginin();
                         String a = in.next();
                         if ("1".equals(a)){
                             System.out.println("�������Ϊ:"+String.valueOf(manager.inquiry()));
                         }else if ("2".equals(a)){
                             try {
                                 System.out.println("����ȡ����Ǯ��");
                                 String qumoney = in.next();
                                 manager.withdrawals(Double.parseDouble(qumoney));
                                 System.out.println("ȡ��ɹ����������Ϊ��"+String.valueOf(manager.inquiry()));
                             }catch (AccountOverDrawnException e){
                                 System.out.println("warning:"+e.getMessage());
                             }
                         }else if("3".equals(a)){
                             try {
                                 System.out.println("��������Ǯ��");
                                 String cunmoney = in.next();
                                 manager.deposit(Double.parseDouble(cunmoney));
                                 System.out.println("���ɹ����������Ϊ��"+String.valueOf(manager.inquiry()));
                             }catch (InvalidDepositException e){
                                 System.out.println("warning:"+e.getMessage());
                             }
                         }else if ("4".equals(a)){
                             System.out.println("����������ת�˵Ķ���");
                             String others = in.next();
                             System.out.println("������ת�˽��");
                             String zhuanmoney=in.next();
                             if(bankDaoImpl.transfer(others,zhuanmoney)) {
                                 System.out.println("ת�˳ɹ�");
                             }else System.out.println("ת��ʧ�ܣ������Ƿ���������");
                         } else if ("5".equals(a)){
                             manager.exitSystem();
                         }

                     }
                 } System.out.println("��¼ʧ�ܣ��û������������");
                 }else if("3".equals(i)){
                 manager.exitSystem();
             }

             }
         }

     }