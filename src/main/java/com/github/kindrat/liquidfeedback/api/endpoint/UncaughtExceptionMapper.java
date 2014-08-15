package com.github.kindrat.liquidfeedback.api.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Component
@Provider
public class UncaughtExceptionMapper implements ExceptionMapper<Throwable>
{
   private static final Logger LOGGER = LoggerFactory.getLogger(UncaughtExceptionMapper.class);

   public Response toResponse(Throwable t)
   {
      if (t instanceof WebApplicationException)
      {
         return ((WebApplicationException) t).getResponse();
      }
      else
      {
         LOGGER.error("Uncaught exception thrown by REST service", t);
         return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(t.getMessage()).build();
      }
   }
}