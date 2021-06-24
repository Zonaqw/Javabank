
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
        System.out.println("������������������  ��ӭ��������   ������������������");
        while (true) {
            System.out.println("��������     ����ִ�����²���   ����������������");
            System.out.println("������ 1:��ѯ 2:ȡ�� 3:��� 4:�˳�����������");
            System.out.println("��������������������������������������������������������������������");
            String a = in.next();
            if("1".equals(a)){
                System.out.println("�������Ϊ:"+manager.inquiry());
            }else if ("2".equals(a)){
                try {
                    System.out.println("��������ȡ����Ǯ��");
                    String money = in.next();//����ȡ����
                    Double qumoney = Double.parseDouble(money);
                    manager.withdrawals(qumoney);//����ȡ���withdrawals()
                    System.out.println("ȡ��ɹ����������Ϊ:"+manager.inquiry());
                }catch (AccountOverDrawnException e) {
                    System.out.println("warning"+e.getMessage());
                   // e.printStackTrace();
                }
            }else if ("3".equals(a)){
                try {
                    System.out.println("������������Ǯ��");
                    String money = in.next();//��������
                    Double cunmoney = Double.parseDouble(money);
                    manager.deposit(cunmoney);//���ô���deposit()
                    System.out.println("���ɹ����������Ϊ:"+manager.inquiry());
                }catch (InvalidDepositException e){
                    System.out.println("warning"+e.getMessage());
                   // e.printStackTrace();
                }
            }else if ("4".equals(a)){
                System.out.println("�˳��ɹ�����ӭ�´ι���");
                manager.exitSystem();
            }
        }
    }

 }



