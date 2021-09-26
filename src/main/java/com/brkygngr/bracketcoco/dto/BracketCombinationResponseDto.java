package com.brkygngr.bracketcoco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigInteger;

@Valid
public class BracketCombinationResponseDto {

  @PositiveOrZero
  private final BigInteger totalCombinations;

  public BracketCombinationResponseDto(final BigInteger totalCombinations) {
    this.totalCombinations = totalCombinations;
  }

  @JsonProperty("tc")
  public BigInteger getTotalCombinations() {
    return totalCombinations;
  }
}
