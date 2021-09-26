package com.brkygngr.bracketcoco.validator;

import javax.ejb.Local;

@Local
public interface NumberValidator {
  boolean valid(int number);
  boolean invalid(int number);
  void throwError();
}
