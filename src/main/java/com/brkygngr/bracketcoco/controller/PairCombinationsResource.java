package com.brkygngr.bracketcoco.controller;

import com.brkygngr.bracketcoco.ejb.combinations.pair.PairCombinations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

@Path("combinations")
@Stateless
public class PairCombinationsResource {

  @EJB
  private PairCombinations pairCombinations;

  @GET
  @Path("bracket")
  @Consumes("application/json")
  @Produces("application/json")
  public int bracketCombinations(@NotNull @Min(0) @Max(Integer.MAX_VALUE) @QueryParam("pairCount") int pairCount) {
    return pairCombinations.totalCombinations(pairCount);
  }
}
