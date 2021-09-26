package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.validator.NumberValidator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ParallelFactorialEquationTest {

  @Mock
  private NumberValidator numberValidator;

  @InjectMocks
  private ParallelFactorialEquation parallelFactorialEquation;

  @Nested
  class Factorials_can_calculate {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "4, 24", "6, 720", "100, 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"})
    void positive_numbers(final String givenNumber, final String givenExpected) {
      BigInteger number = new BigInteger(givenNumber);
      BDDMockito.given(numberValidator.invalid(number)).willReturn(false);
      assertEquals(parallelFactorialEquation.factorial(number), new BigInteger(givenExpected));
    }
  }

  @Nested
  class Factorial_throws {
    @ParameterizedTest
    @ValueSource(strings = {"-100", "-5", "-2", "-1"})
    void illegal_argument_for_negative_numbers(final String givenNumber) {
      BigInteger number = new BigInteger(givenNumber);
      BDDMockito.given(numberValidator.invalid(number)).willReturn(true);
      BDDMockito.doThrow(IllegalArgumentException.class).when(numberValidator).throwError();
      assertThrows(IllegalArgumentException.class, () -> parallelFactorialEquation.factorial(number));
    }

    @Test
    public void illegal_argument_for_integer_min_value() {
      BigInteger number = BigInteger.valueOf(Integer.MIN_VALUE);
      BDDMockito.given(numberValidator.invalid(number)).willReturn(true);
      BDDMockito.doThrow(IllegalArgumentException.class).when(numberValidator).throwError();
      assertThrows(IllegalArgumentException.class, () -> parallelFactorialEquation.factorial(number));
    }
  }
}