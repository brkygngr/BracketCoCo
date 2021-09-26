package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.validator.NumberValidator;
import com.brkygngr.bracketcoco.validator.PositiveNumberValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FactorialCatalanNumberEquationTest {

  private FactorialCatalanNumberEquation factorialCatalanNumberEquation;

  @BeforeEach
  void beforeEach() {
    NumberValidator numberValidator = new PositiveNumberValidator();
    factorialCatalanNumberEquation = new FactorialCatalanNumberEquation(numberValidator, new ParallelFactorialEquation(numberValidator));
  }

  @Nested
  class Catalan_number_can_calculate {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2,2", "3,5", "6, 132", "25, 4861946401452"})
    void positive_numbers(final String givenPairCount, final String givenExpected) {
      assertEquals(new BigInteger(givenExpected), factorialCatalanNumberEquation.catalanNumber(new BigInteger(givenPairCount)));
    }

    @Test
    void big_numbers() {
      factorialCatalanNumberEquation.catalanNumber(new BigInteger("5000"));
    }
  }

  @Nested
  class Catalan_number_throws {
    @ParameterizedTest
    @ValueSource(strings = {"-100", "-5", "-2", "-1"})
    public void illegal_argument_for_negative_numbers(final String givenNumber) {
      assertThrows(IllegalArgumentException.class, () -> factorialCatalanNumberEquation.catalanNumber(new BigInteger(givenNumber)));
    }

    @Test
    public void illegal_argument_for_integer_min_value() {
      assertThrows(IllegalArgumentException.class, () -> factorialCatalanNumberEquation.catalanNumber(BigInteger.valueOf(Integer.MIN_VALUE)));
    }
  }
}