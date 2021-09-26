package com.brkygngr.bracketcoco.controller;

import com.brkygngr.bracketcoco.calculator.combination.BracketCombinationCalculator;
import com.brkygngr.bracketcoco.dto.BracketCombinationRequestDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
  @Consumes("application/json")
  @Produces("application/json")
  public int bracketCombinations(final int i) {
    return bracketCombinationCalculator.totalCombinations(i);
  }
}
