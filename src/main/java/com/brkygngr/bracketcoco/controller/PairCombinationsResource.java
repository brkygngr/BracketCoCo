package com.brkygngr.bracketcoco.controller;

import com.brkygngr.bracketcoco.ejb.combinations.pair.PairCombinations;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.ws.rs.*;

@Path("combinations")
@Stateless
public class PairCombinationsResource {

  private final PairCombinations pairCombinations;

  @Inject
  public PairCombinationsResource(final PairCombinations pairCombinations) {
    this.pairCombinations = pairCombinations;
  }

  @GET
  @Path("bracket")
  @Consumes("application/json")
  @Produces("application/json")
  public int bracketCombinations(@Valid @PositiveOrZero @Max(Integer.MAX_VALUE) @QueryParam("pairCount") final int pairCount) {
    return pairCombinations.totalCombinations(pairCount);
  }
}
