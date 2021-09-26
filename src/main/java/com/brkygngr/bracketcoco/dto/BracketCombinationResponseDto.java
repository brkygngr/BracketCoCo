package com.brkygngr.bracketcoco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

@Valid
public class BracketCombinationResponseDto {
  @PositiveOrZero
  @Max(Integer.MAX_VALUE)
  @JsonProperty("tc")
  private final int totalCombinations;

  public BracketCombinationResponseDto(final int totalCombinations) {
    this.totalCombinations = totalCombinations;
  }

  public int getTotalCombinations() {
    return totalCombinations;
  }
}
