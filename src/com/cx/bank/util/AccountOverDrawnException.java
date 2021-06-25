
 package com.cx.bank.util;
 /*
 *异常类，当取款超出余额或为负数时报告异常
 * */
 public class AccountOverDrawnException extends Exception {
     public AccountOverDrawnException(){}
     public AccountOverDrawnException(String message) { super(message); }
 }