package com.brkygngr.bracketcoco.ejb.stateless;

import com.brkygngr.bracketcoco.ejb.PairCombinationsBean;

import javax.ejb.Stateless;

@Stateless
public class BracketPairCombinationsBean implements PairCombinationsBean {
  @Override
  public int totalCombinations(int pairCount) {
    return 0;
  }
}
