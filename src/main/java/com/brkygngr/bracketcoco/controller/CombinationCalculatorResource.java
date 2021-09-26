package com.brkygngr.bracketcoco.controller;

import com.brkygngr.bracketcoco.calculator.CalculatorConstants;
import com.brkygngr.bracketcoco.calculator.combination.BracketCombinationCalculator;
import com.brkygngr.bracketcoco.dto.BracketCombinationResponseDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;

@Path("combinations")
@Stateless
public class CombinationCalculatorResource {

  private final BracketCombinationCalculator bracketCombinationCalculator;

  @Inject
  public CombinationCalculatorResource(BracketCombinationCalculator bracketCombinationCalculator) {
    this.bracketCombinationCalculator = bracketCombinationCalculator;
  }

  @GET
  @Path("bracket")
  @Produces(MediaType.APPLICATION_JSON)
  public BracketCombinationResponseDto bracketCombinations(@Valid @PositiveOrZero @Max(CalculatorConstants.ACCEPTED_MAX_PAIR_COUNT) @QueryParam("pairCount") final int pairCount) {
    return new BracketCombinationResponseDto(bracketCombinationCalculator.totalCombinations(BigInteger.valueOf(pairCount)));
  }
}
