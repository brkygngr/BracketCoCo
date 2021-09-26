package com.brkygngr.bracketcoco.calculator.equation;

import javax.ejb.Local;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Local
public interface FactorialEquation {
  long factorial(@Valid @PositiveOrZero int number);
}
