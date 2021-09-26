package com.brkygngr.bracketcoco.validator;

import javax.ejb.Local;
import java.math.BigInteger;

@Local
public interface NumberValidator {
  boolean valid(BigInteger number);
  boolean invalid(BigInteger number);
  void throwError();
}
