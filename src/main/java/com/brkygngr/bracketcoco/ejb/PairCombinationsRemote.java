package com.brkygngr.bracketcoco.ejb;

import javax.ejb.Remote;

@Remote
public interface PairCombinationsRemote {
  int totalCombinations(int pairCount);
}
