package com.brkygngr.bracketcoco.ejb.combinations.pair;

import javax.ejb.Local;

@Local
public interface PairCombinationsValidator {
  boolean valid(int pairCount);
}
