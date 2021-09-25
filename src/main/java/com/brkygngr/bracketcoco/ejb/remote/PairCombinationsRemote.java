package com.brkygngr.bracketcoco.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface PairCombinationsRemote {
  int totalCombinations(int pairCount);
}
