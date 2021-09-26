package com.brkygngr.bracketcoco.provider;

import com.brkygngr.bracketcoco.dto.BracketCombinationResponseDto;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OutOfMemoryExceptionMapper
        implements ExceptionMapper<OutOfMemoryError> {

  @Override
  public Response toResponse(OutOfMemoryError exception) {
    String error = "The memory given to the application is not sufficient. " +
            "Try entering a smaller number or increase jvm memory.";

    BracketCombinationResponseDto bracketCombinationResponseDto = new BracketCombinationResponseDto(error);

    return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(bracketCombinationResponseDto)
            .type(MediaType.APPLICATION_JSON).build();
  }
}
