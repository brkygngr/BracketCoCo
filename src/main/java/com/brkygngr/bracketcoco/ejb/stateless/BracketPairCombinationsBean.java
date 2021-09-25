package com.brkygngr.bracketcoco.ejb.stateless;

import com.brkygngr.bracketcoco.ejb.PairCombinationsRemote;

import javax.ejb.Stateless;

@Stateless
public class BracketPairCombinationsBean implements PairCombinationsRemote {
  @Override
  public int totalCombinations(int pairCount) {
    return 0;
  }
}
