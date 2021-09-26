package com.brkygngr.bracketcoco.calculator.combination;

import com.brkygngr.bracketcoco.calculator.equation.CatalanNumberEquation;
import com.brkygngr.bracketcoco.validator.NumberValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CatalanBracketCombinationCalculatorTest {

  @Mock
  private NumberValidator numberValidator;

  @Mock
  private CatalanNumberEquation catalanNumberEquation;

  @InjectMocks
  private CatalanBracketCombinationCalculator catalanBracketCombinationCalculator;

  @Test
  void totalCombinations_canCalculateForZero() {
    assertEquals(0, catalanBracketCombinationCalculator.totalCombinations(0));
  }

  @ParameterizedTest
  @CsvSource({"1, 1", "2, 2", "3, 5", "4, 14", "5, 42", "25, 4861946401452"})
  void totalCombinations_canCalculateForValidPairCounts(final int pairCount, final Long expected) {
    BDDMockito.given(numberValidator.invalid(pairCount)).willReturn(false);
    BDDMockito.given(catalanNumberEquation.catalanNumber(pairCount)).willReturn(expected);
    assertEquals(expected, catalanBracketCombinationCalculator.totalCombinations(pairCount));
    BDDMockito.verify(catalanNumberEquation, Mockito.times(1)).catalanNumber(pairCount);
  }

  @ParameterizedTest
  @ValueSource(ints = {-100, -5, -2, -1, Integer.MIN_VALUE})
  void totalCombinations_throwsIllegalArgumentExceptionForNegativeNumbers(final int pairCount) {
    BDDMockito.given(numberValidator.invalid(pairCount)).willReturn(true);
    BDDMockito.doThrow(IllegalArgumentException.class).when(numberValidator).throwError();
    assertThrows(IllegalArgumentException.class, () -> catalanBracketCombinationCalculator.totalCombinations(pairCount));
    BDDMockito.verify(numberValidator, Mockito.times(1)).invalid(pairCount);
    BDDMockito.verify(numberValidator, Mockito.times(1)).throwError();
  }
}