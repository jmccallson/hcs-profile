package org.hcs.exceptions;

public class ProfileUnauthorizedException extends Exception{
  public ProfileUnauthorizedException(String message, Throwable throwable){
    super(message, throwable);
  }
}
