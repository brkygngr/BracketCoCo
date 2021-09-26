package com.brkygngr.bracketcoco.calculator.combination;

import javax.ejb.Local;

@Local
public interface BracketCombinationCalculator {
  int totalCombinations(int pairCount);
}
