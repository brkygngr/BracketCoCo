package com.brkygngr.bracketcoco.calculator.combination;

import com.brkygngr.bracketcoco.calculator.equation.CatalanNumberEquation;
import com.brkygngr.bracketcoco.validator.NumberValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CatalanBracketCombinationCalculatorTest {

  @Mock
  private NumberValidator numberValidator;

  @Mock
  private CatalanNumberEquation catalanNumberEquation;

  @InjectMocks
  private CatalanBracketCombinationCalculator catalanBracketCombinationCalculator;

  @Nested
  class Total_combinations_can_calculate {
    @Test
    void zero() {
      assertEquals(BigInteger.ZERO, catalanBracketCombinationCalculator.totalCombinations(BigInteger.ZERO));
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 5", "4, 14", "5, 42", "25, 4861946401452"})
    void positive_numbers(final String givenPairCount, final String givenExpected) {
      BigInteger pairCount = new BigInteger(givenPairCount);
      BigInteger expected = new BigInteger(givenExpected);

      BDDMockito.given(numberValidator.invalid(pairCount)).willReturn(false);
      BDDMockito.given(catalanNumberEquation.catalanNumber(pairCount)).willReturn(expected);
      assertEquals(expected, catalanBracketCombinationCalculator.totalCombinations(pairCount));
      BDDMockito.verify(catalanNumberEquation, Mockito.times(1)).catalanNumber(pairCount);
    }
  }

  @Nested
  class Total_combinations_throws {
    @ParameterizedTest
    @ValueSource(strings = {"-100", "-5", "-2", "-1"})
    void illegal_argument_exception_for_negative_numbers(final String givenPairCount) {
      BigInteger pairCount = new BigInteger(givenPairCount);
      BDDMockito.given(numberValidator.invalid(pairCount)).willReturn(true);
      BDDMockito.doThrow(IllegalArgumentException.class).when(numberValidator).throwError();
      assertThrows(IllegalArgumentException.class, () -> catalanBracketCombinationCalculator.totalCombinations(pairCount));
      BDDMockito.verify(numberValidator, Mockito.times(1)).invalid(pairCount);
      BDDMockito.verify(numberValidator, Mockito.times(1)).throwError();
    }

    @Test
    void illegal_argument_exception_for_integer_min_value() {
      BigInteger pairCount = BigInteger.valueOf(Integer.MIN_VALUE);
      BDDMockito.given(numberValidator.invalid(pairCount)).willReturn(true);
      BDDMockito.doThrow(IllegalArgumentException.class).when(numberValidator).throwError();
      assertThrows(IllegalArgumentException.class, () -> catalanBracketCombinationCalculator.totalCombinations(pairCount));
      BDDMockito.verify(numberValidator, Mockito.times(1)).invalid(pairCount);
      BDDMockito.verify(numberValidator, Mockito.times(1)).throwError();
    }
  }
}