
 package com.cx.bank.util;
 /*
 *�쳣�࣬��ȡ�������Ϊ����ʱ�����쳣
 * */
 public class AccountOverDrawnException extends Exception {
     public AccountOverDrawnException(){}
     public AccountOverDrawnException(String message) { super(message); }
 }