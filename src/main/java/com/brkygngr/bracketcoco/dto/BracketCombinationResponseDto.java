package com.brkygngr.bracketcoco.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Valid
public class BracketCombinationResponseDto {

  @PositiveOrZero
  @JsonbProperty("tc")
  private final BigInteger totalCombinations;

  public BracketCombinationResponseDto(final BigInteger totalCombinations) {
    this.totalCombinations = totalCombinations;
  }

  public BigInteger getTotalCombinations() {
    return totalCombinations;
  }
}
