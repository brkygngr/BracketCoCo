package com.brkygngr.bracketcoco.calculator.combination;

import javax.ejb.Local;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Local
public interface BracketCombinationCalculator {

  BigInteger totalCombinations(@NotNull @PositiveOrZero BigInteger pairCount);
}
