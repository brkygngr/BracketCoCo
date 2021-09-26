package com.brkygngr.bracketcoco.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

@Valid
public class BracketCombinationRequestDto {
  @PositiveOrZero
  @Max(Integer.MAX_VALUE)
  private final int value;

  public BracketCombinationRequestDto(final int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
