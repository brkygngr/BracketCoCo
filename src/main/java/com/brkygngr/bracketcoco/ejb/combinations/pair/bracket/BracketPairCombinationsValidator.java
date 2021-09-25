package com.brkygngr.bracketcoco.ejb.combinations.pair.bracket;

import com.brkygngr.bracketcoco.ejb.combinations.pair.PairCombinationsValidator;

import javax.ejb.Stateless;

@Stateless
public class BracketPairCombinationsValidator implements PairCombinationsValidator {
  @Override
  public boolean valid(int pairCount) {
    return false;
  }
}
