
 package com.cx.bank.test;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
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
                    int a = in.nextInt();
                    switch (a) {
                        //��ѯ���
                        case 1: {
                            System.out.println("�������Ϊ��" + manager.inquiry());
                        }
                        break;
                        //ȡ��
                        case 2: {
                            System.out.println("����ȡ����Ǯ��");
                            double qumoney = in.nextDouble();
                            boolean flag=  manager.withdrawals(qumoney);
                            if(flag) {
                                System.out.println("ȡ��ɹ����������Ϊ��" + manager.inquiry());
                            }else {
                                System.out.println("ȡ��ʧ��");
                            }
                        }
                        break;
                        //���
                        case 3: {
                            System.out.println("��������Ǯ��");
                            double cunmoney = in.nextDouble();
                            boolean flag = manager.deposit(cunmoney);
                            if (flag) {
                                System.out.println("���ɹ����������Ϊ��" + manager.inquiry());
                            }else {
                                System.out.println("���ʧ��");
                            }
                        }
                        break;
                        //�˳�ϵͳ
                        case 4: {
                            System.out.println("�˳��ɹ�����ӭ�´ι���");
                            manager.exitSystem();
                        }
                        default :{
                            System.out.println("��������������");
                        }break ;
                    }
               }

    }

 }



