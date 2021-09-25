package com.brkygngr.bracketcoco.ejb.combinations.pair.bracket;

import com.brkygngr.bracketcoco.ejb.combinations.pair.PairCombinations;
import com.brkygngr.bracketcoco.utility.MathUtility;

import javax.ejb.Stateless;
import javax.validation.constraints.Min;

@Stateless
public class BracketPairCombinations implements PairCombinations {
  @Override
  public int totalCombinations(@Min(0) final int pairCount) {
    if (pairCount == 0) {
      return 0;
    }

    return MathUtility.catalan(pairCount);
  }
}
