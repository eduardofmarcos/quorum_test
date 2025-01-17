package org.quorum.filters;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * Exception mapper for handling NotFoundException. Redirects any unresolved routes to the Swagger
 * UI.
 */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

  /**
   * Handles NotFoundException by redirecting to Swagger UI.
   *
   * @param exception the NotFoundException instance
   * @return a Response object with a redirection to "/q/swagger-ui"
   */
  @Override
  public Response toResponse(NotFoundException exception) {
    return Response.status(Response.Status.TEMPORARY_REDIRECT)
        .header("Location", "/q/swagger-ui")
        .build();
  }
}