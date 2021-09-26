package com.brkygngr.bracketcoco.calculator.equation;

import javax.ejb.Local;

@Local
public interface FactorialEquation {
  int factorial(int number);
}
