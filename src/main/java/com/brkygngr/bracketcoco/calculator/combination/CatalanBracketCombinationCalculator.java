package com.brkygngr.bracketcoco.calculator.combination;

import com.brkygngr.bracketcoco.calculator.equation.CatalanNumberEquation;
import com.brkygngr.bracketcoco.validator.NumberValidator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;
import java.util.Objects;

@Stateless
public class CatalanBracketCombinationCalculator implements BracketCombinationCalculator {

  private final NumberValidator numberValidator;

  private final CatalanNumberEquation catalanNumberEquation;

  @Inject
  public CatalanBracketCombinationCalculator(final NumberValidator numberValidator, final CatalanNumberEquation catalanNumberEquation) {
    this.numberValidator = numberValidator;
    this.catalanNumberEquation = catalanNumberEquation;
  }

  @Override
  public BigInteger totalCombinations(@NotNull @PositiveOrZero final BigInteger pairCount) {
    if (numberValidator.invalid(pairCount)) {
      numberValidator.throwError();
    }

    if (Objects.equals(pairCount, BigInteger.ZERO)) {
      return BigInteger.ZERO;
    }

    return catalanNumberEquation.catalanNumber(pairCount);
  }
}
