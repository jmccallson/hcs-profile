package org.hcs.exceptions;

public class ProfileExpiredSessionException extends Exception{
  public ProfileExpiredSessionException(String message, Throwable throwable){
    super(message, throwable);
  }
}
