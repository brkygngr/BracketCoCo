package com.brkygngr.bracketcoco.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import java.math.BigInteger;

@Valid
public class BracketCombinationResponseDto {

  @JsonbProperty("tc")
  private BigInteger totalCombinations;

  @JsonbProperty("e")
  private String error;

  public BracketCombinationResponseDto(final BigInteger totalCombinations) {
    this.totalCombinations = totalCombinations;
  }

  public BracketCombinationResponseDto(final String error) {
    this.error = error;
  }

  public BigInteger getTotalCombinations() {
    return totalCombinations;
  }

  public String getError() {
    return error;
  }
}
