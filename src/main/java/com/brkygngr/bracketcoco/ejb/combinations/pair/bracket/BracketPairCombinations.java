package com.brkygngr.bracketcoco.ejb.combinations.pair.bracket;

import com.brkygngr.bracketcoco.ejb.combinations.pair.PairCombinations;
import com.brkygngr.bracketcoco.ejb.combinations.pair.PairCombinationsValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class BracketPairCombinations implements PairCombinations {

  private static final String ILLEGAL_PAIR_COUNT = "Count must be between 0 and " + Integer.MAX_VALUE;

  private final PairCombinationsValidator pairCombinationsValidator;

  @Inject
  public BracketPairCombinations(PairCombinationsValidator pairCombinationsValidator) {
    this.pairCombinationsValidator = pairCombinationsValidator;
  }

  @Override
  public int totalCombinations(final int pairCount) {
    boolean notValid = !pairCombinationsValidator.valid(pairCount);

    if (notValid) {
      throw new IllegalArgumentException(ILLEGAL_PAIR_COUNT);
    }

    return 0;
  }
}
