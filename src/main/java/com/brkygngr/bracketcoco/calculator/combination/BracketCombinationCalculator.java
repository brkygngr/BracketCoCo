package com.brkygngr.bracketcoco.calculator.combination;

import javax.ejb.Local;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Local
public interface BracketCombinationCalculator {
  long totalCombinations(@Valid @PositiveOrZero int pairCount);
}
