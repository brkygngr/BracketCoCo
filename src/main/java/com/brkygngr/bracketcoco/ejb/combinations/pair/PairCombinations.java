package com.brkygngr.bracketcoco.ejb.combinations.pair;

import javax.ejb.Local;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Local
public interface PairCombinations {
  int totalCombinations(@Valid @PositiveOrZero final int pairCount);
}
