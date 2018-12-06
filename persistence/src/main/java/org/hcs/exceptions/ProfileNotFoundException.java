package org.hcs.exceptions;

public class ProfileNotFoundException extends Exception {
  public ProfileNotFoundException(String mess) {
    super(mess);
  }
  public ProfileNotFoundException(String mess, Throwable cause) {
    super(mess, cause);
  }
}
