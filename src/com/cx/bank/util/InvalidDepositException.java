
 package com.cx.bank.util;
/*
* �쳣�࣬�����Ϊ����ʱ�����쳣
* */
 public class InvalidDepositException extends Exception {
    public InvalidDepositException(){ super(); }
    public InvalidDepositException(String message){ super(message); }
 }