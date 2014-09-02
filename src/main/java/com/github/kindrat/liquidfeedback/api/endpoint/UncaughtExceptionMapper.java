package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.exceptions.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Component
@Provider
public class UncaughtExceptionMapper implements ExceptionMapper<Throwable> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UncaughtExceptionMapper.class);

    public Response toResponse(Throwable t) {
        LOGGER.error("Uncaught exception thrown by REST service", t);

        if (t instanceof WebApplicationException) {
            return ((WebApplicationException) t).getResponse();
        } else if (t instanceof ValidationException) {
            return Response.status(Response.Status.BAD_REQUEST).entity(t.getMessage()).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(t.getMessage()).build();
        }
    }
}