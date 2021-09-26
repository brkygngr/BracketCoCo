package com.brkygngr.bracketcoco.calculator.equation;

import com.brkygngr.bracketcoco.validator.NumberValidator;
import com.brkygngr.bracketcoco.validator.PositiveNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FactorialCatalanNumberEquationTest {

  private FactorialCatalanNumberEquation factorialCatalanNumberEquation;

  @BeforeEach
  void beforeEach() {
    NumberValidator numberValidator = new PositiveNumberValidator();
    factorialCatalanNumberEquation = new FactorialCatalanNumberEquation(numberValidator, new RecursiveFactorialEquation(numberValidator));
  }

  @Nested
  class ValidNumbers {
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2,2", "3,5", "6, 132", "25, 4861946401452"})
    void canCalculate(final int number, final int expected) {
      assertEquals(factorialCatalanNumberEquation.catalanNumber(number), expected);
    }
  }

  @Nested
  class InvalidNumbers {
    @ParameterizedTest
    @ValueSource(ints = {-100, -5, -2, -1})
    public void throwsIllegalArgument(final int number) {
      assertThrows(IllegalArgumentException.class, () -> factorialCatalanNumberEquation.catalanNumber(number));
    }
  }
}