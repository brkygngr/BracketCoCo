package com.brkygngr.bracketcoco.ejb.combinations.pair.bracket;

import com.brkygngr.bracketcoco.ejb.combinations.pair.PairCombinations;
import com.brkygngr.bracketcoco.utility.MathUtility;
import com.brkygngr.bracketcoco.validator.PositiveNumberValidator;

import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Stateless
public class BracketPairCombinations implements PairCombinations {
  @Override
  public int totalCombinations(@Valid @PositiveOrZero final int pairCount) {
    PositiveNumberValidator.throwErrorIfNegative(pairCount);

    if (pairCount == 0) {
      return 0;
    }

    return MathUtility.catalan(pairCount);
  }
}
