package com.brkygngr.bracketcoco.controller;

import javax.ws.rs.*;

@Path("combinations")
public class CombinationsController {

  @Path("bracket")
  @GET
  @Consumes("application/json")
  @Produces("application/json")
  public int bracketCombinations(@QueryParam("pairCount") int pairCount) {
    return 0;
  }
}
