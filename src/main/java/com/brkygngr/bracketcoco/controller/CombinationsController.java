package com.brkygngr.bracketcoco.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("combinations")
public class CombinationsController {

  @Path("bracket")
  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public int bracketCombinations(int pairCount) {
    return 0;
  }
}
