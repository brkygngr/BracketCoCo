package com.brkygngr.bracketcoco.ejb.combinations.pair;

import javax.ejb.Local;

@Local
public interface PairCombinations {
  int totalCombinations(int pairCount);
}
