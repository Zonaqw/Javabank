
 package com.cx.bank.util;
/*
* 异常类，当存款为负数时报告异常
* */
 public class InvalidDepositException extends RuntimeException {
    public InvalidDepositException(){ super(); }
    public InvalidDepositException(String message){ super(message); }
 }