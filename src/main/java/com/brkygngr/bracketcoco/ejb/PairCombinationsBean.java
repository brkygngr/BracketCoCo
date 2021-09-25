package com.brkygngr.bracketcoco.ejb;

import javax.ejb.Remote;

@Remote
public interface PairCombinationsBean {
  int totalCombinations(int pairCount);
}
