package org.hcs.exceptions;

public class ProfileConflictException  extends Exception {
  public ProfileConflictException(String mess) {
    super(mess);
  }
  public ProfileConflictException(String mess, Throwable cause) {
    super(mess, cause);
  }
}
