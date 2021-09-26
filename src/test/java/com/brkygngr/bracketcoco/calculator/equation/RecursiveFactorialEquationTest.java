package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.validator.NumberValidator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RecursiveFactorialEquationTest {

  @Mock
  private NumberValidator numberValidator;

  @InjectMocks
  private RecursiveFactorialEquation recursiveFactorialEquation;

  @Nested
  class ValidNumbers {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "4, 24", "6, 720"})
    void canCalculate(final int number, final int expected) {
      BDDMockito.given(numberValidator.invalid(number)).willReturn(false);
      assertEquals(recursiveFactorialEquation.factorial(number), expected);
    }
  }

  @Nested
  class InvalidNumbers {
    @ParameterizedTest
    @ValueSource(ints = {-100, -5, -2, -1})
    void totalCombinations_throwsIllegalArgumentExceptionForNegativeNumbers(final int number) {
      BDDMockito.given(numberValidator.invalid(number)).willReturn(true);
      BDDMockito.doThrow(IllegalArgumentException.class).when(numberValidator).throwError();
      assertThrows(IllegalArgumentException.class, () -> recursiveFactorialEquation.factorial(number));
    }
  }
}