package com.brkygngr.bracketcoco.calculator.equation;

import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Local
public interface CatalanNumberEquation {
  BigInteger catalanNumber(@NotNull @PositiveOrZero BigInteger pairCount);
}
