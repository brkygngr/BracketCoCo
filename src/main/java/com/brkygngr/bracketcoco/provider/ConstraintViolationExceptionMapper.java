package com.brkygngr.bracketcoco.provider;

import com.brkygngr.bracketcoco.dto.BracketCombinationResponseDto;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionMapper
        implements ExceptionMapper<ConstraintViolationException> {

  @Override
  public Response toResponse(ConstraintViolationException exception) {
    String error = exception
            .getConstraintViolations()
            .stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toList())
            .toString();

    BracketCombinationResponseDto bracketCombinationResponseDto = new BracketCombinationResponseDto(error);

    return Response
            .status(Response.Status.BAD_REQUEST)
            .entity(bracketCombinationResponseDto)
            .type(MediaType.APPLICATION_JSON).build();
  }
}
