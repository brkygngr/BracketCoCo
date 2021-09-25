package com.brkygngr.bracketcoco.ejb.combinations.pair;

import javax.ejb.Local;

@Local
public interface PairCombinationsBean {
  int totalCombinations(int pairCount);
}
