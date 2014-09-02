package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.BaseDto;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityConversionException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

public abstract class AbstractApi<DTO extends BaseDto<ENTITY>, ENTITY extends BaseEntity<DTO>> {

    protected final Logger logger = LoggerFactory.getLogger(getClass().getCanonicalName());

    @Context
    private UriInfo uriInfo;

    protected Response getResponse(DTO response, Response.Status code) throws EntityConversionException {
        return getBuilder(code).entity(response.convertAndGet()).build();
    }

    protected Response getResponse(List<DTO> entities) throws EntityConversionException {
        Response.Status code = entities.isEmpty() ? Response.Status.NOT_FOUND : Response.Status.OK;
        return getBuilder(code).entity(entities).build();
    }

    protected Response getResponse(List<DTO> entities, Response.Status code) throws EntityConversionException {
        return getBuilder(code).entity(entities).build();
    }

    protected Response getResponse(Response.Status code) {
        return getBuilder(code).entity(null).build();
    }

    protected Response getResponse(Throwable t, Response.Status code) {
        return getBuilder(code).entity(t).build();
    }

    private Response.ResponseBuilder getBuilder(Response.Status code) {
        return Response.status(code).header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, DELETE, OPTIONS");
    }
}
