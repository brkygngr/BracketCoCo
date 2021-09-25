package com.brkygngr.bracketcoco.utility;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilityTest {

  @Nested
  class Factorial {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "4, 24", "6, 720"})
    void canCalculateForValidNumbers(final int number, final int expected) {
      assertEquals(MathUtility.factorial(number), expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -5, -2, -1})
    public void totalCombinations_throwsIllegalArgumentExceptionForNegativeNumbers(final int number) {
      assertThrows(IllegalArgumentException.class, () -> MathUtility.factorial(number));
    }
  }

  @Nested
  class Catalan {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2,2", "3,5", "6, 132"})
    void canCalculateForValidNumbers(final int number, final int expected) {
      assertEquals(MathUtility.catalan(number), expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -5, -2, -1})
    public void totalCombinations_throwsIllegalArgumentExceptionForNegativeNumbers(final int number) {
      assertThrows(IllegalArgumentException.class, () -> MathUtility.catalan(number));
    }
  }
}