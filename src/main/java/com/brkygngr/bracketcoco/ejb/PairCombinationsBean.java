package com.brkygngr.bracketcoco.ejb;

import javax.ejb.Local;

@Local
public interface PairCombinationsBean {
  int totalCombinations(int pairCount);
}
