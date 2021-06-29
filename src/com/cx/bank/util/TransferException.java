package com.cx.bank.util;

import com.cx.bank.manager.ManagerImpl;

public class TransferException extends Exception{
  public TransferException(){}
  public TransferException(String message) {
      super(message);
  }
}
