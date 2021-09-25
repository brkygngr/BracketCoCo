package com.brkygngr.bracketcoco.controller;

import com.brkygngr.bracketcoco.ejb.PairCombinationsBean;
import com.brkygngr.bracketcoco.ejb.stateless.BracketPairCombinationsBean;

import javax.ejb.EJB;
import javax.ws.rs.*;

@Path("combinations")
public class CombinationsResource {

  @EJB(beanInterface = BracketPairCombinationsBean.class)
  private final PairCombinationsBean pairCombinationsBean;

  public CombinationsResource(PairCombinationsBean pairCombinationsBean) {
    this.pairCombinationsBean = pairCombinationsBean;
  }

  @GET
  @Path("bracket")
  @Consumes("application/json")
  @Produces("application/json")
  public int bracketCombinations(@QueryParam("pairCount") int pairCount) {
    return pairCombinationsBean.totalCombinations(pairCount);
  }
}
