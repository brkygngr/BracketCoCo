package com.brkygngr.bracketcoco.ejb.stateless;

import com.brkygngr.bracketcoco.ejb.combinations.pair.bracket.BracketPairCombinations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BracketPairCombinationsBeanTest {

  private BracketPairCombinations bracketPairCombinations;

  @BeforeEach
  public void beforeEach() {
    bracketPairCombinations = new BracketPairCombinations();
  }

  @ParameterizedTest
  @CsvSource({"0, 0", "1, 1", "2, 2", "3, 5", "4, 14", "5, 42"})
  public void totalCombinations_canCalculateForValidPairCounts(final int pairCount, final int expected) {
    assertEquals(bracketPairCombinations.totalCombinations(pairCount), expected);
  }

  @ParameterizedTest
  @ValueSource(ints = {-100, -5, -2, -1, Integer.MIN_VALUE})
  public void totalCombinations_throwsIllegalArgumentExceptionForNegativeNumbers(final int pairCount) {
    assertThrows(IllegalArgumentException.class, () -> bracketPairCombinations.totalCombinations(pairCount));
  }
}