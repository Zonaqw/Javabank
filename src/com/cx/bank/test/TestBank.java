
 package com.cx.bank.test;
 import com.cx.bank.manager.ManagerImpl;
 import com.cx.bank.model.MoneyBean;
 import java.util.Scanner;

 public class TestBank{
    public static void main(String[] args) {
        ManagerImpl manager = ManagerImpl.getManagerImpl();
        MoneyBean m2 = MoneyBean.getMoneyBean();
        System.out.println("��ӭ��������");
        Scanner in = new Scanner(System.in);
               while (true) {
                 System.out.println("��ѡ�����");
                    System.out.println("0:�˳�ϵͳ   1����ѯ   2��ȡ��   3�����");
                    int a = in.nextInt();
                    switch (a) {
                        //�˳�ϵͳ
                        case 0: {
                            System.out.println("�˳��ɹ�����ӭ�´ι���");
                            manager.exitSystem();
                        }
                        //��ѯ���
                        case 1: {
                            System.out.println("�������Ϊ��" + manager.inquiry());
                        }
                        break;
                        //ȡ��
                        case 2: {
                            System.out.println("ȡǮ���Ϊ��");
                            double qumoney = in.nextDouble();
                            while (qumoney > m2.getMoney()) {
                                System.out.print("���㣬���������룺");
                                qumoney = in.nextDouble();
                            }
                            if (qumoney<0){
                                System.out.println("�����쳣�����������룺");
                                 break;
                            }
                            System.out.println("ȡ��ɹ��� �������Ϊ��" + manager.withdrawals(qumoney));
                        }
                        break;
                        //���
                        case 3: {
                            System.out.println("��Ǯ���Ϊ��");
                            double cunmoney = in.nextDouble();
                            while (cunmoney < 0) {
                                System.out.print("���Ǯ�����Ǹ��������������룺");
                                cunmoney = in.nextDouble();
                            }
                            System.out.println("���ɹ��� �������Ϊ��" + manager.deposit(cunmoney));
                        }
                        break;
                        default :{
                            System.out.println("��������������");
                        }break ;
                    }
               }

    }

 }



