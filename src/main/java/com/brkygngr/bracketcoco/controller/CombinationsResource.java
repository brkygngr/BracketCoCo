package com.brkygngr.bracketcoco.controller;

import com.brkygngr.bracketcoco.ejb.PairCombinationsBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;

@Path("combinations")
@Stateless
public class CombinationsResource {

  @EJB
  private PairCombinationsBean pairCombinationsBean;

  public CombinationsResource() {
  }

  @GET
  @Path("bracket")
  @Consumes("application/json")
  @Produces("application/json")
  public int bracketCombinations(@QueryParam("pairCount") int pairCount) {
    return pairCombinationsBean.totalCombinations(pairCount);
  }
}
