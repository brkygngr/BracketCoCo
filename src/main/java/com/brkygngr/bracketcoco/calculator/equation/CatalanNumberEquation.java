package com.brkygngr.bracketcoco.calculator.equation;

import javax.ejb.Local;

@Local
public interface CatalanNumberEquation {
  int catalanNumber(int pairCount);
}
