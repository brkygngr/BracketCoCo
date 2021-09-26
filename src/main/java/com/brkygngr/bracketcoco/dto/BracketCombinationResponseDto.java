package com.brkygngr.bracketcoco.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

@Valid
public class BracketCombinationResponseDto {

  @PositiveOrZero
  private final long totalCombinations;

  public BracketCombinationResponseDto(final long totalCombinations) {
    this.totalCombinations = totalCombinations;
  }

  @JsonProperty("tc")
  public long getTotalCombinations() {
    return totalCombinations;
  }
}
