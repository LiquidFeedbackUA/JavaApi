package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.context.AppContext;
import com.github.kindrat.liquidfeedback.api.endpoint.dto.BaseDto;
import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import com.github.kindrat.liquidfeedback.api.validation.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractApi<DTO extends BaseDto<ENTITY>, ENTITY extends BaseEntity<DTO>> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractApi.class);

    @Autowired
    protected AppContext appContext;

    @Context
    private UriInfo uriInfo;

    @PostConstruct
    private void setUp() {
        //TODO
    }

    protected Response getResponse(ENTITY response) throws InvocationTargetException, IllegalAccessException {
        return response == null ?
                getResponse(null, null, Response.Status.NOT_FOUND) : getResponse(response.convertAndGet(), null, Response.Status.OK);
    }

    protected Response getResponse(ENTITY response, Response.Status code) throws InvocationTargetException, IllegalAccessException {
        return getResponse(response.convertAndGet(), null, code);
    }

    protected Response getResponse(Object response, Response.Status code) {
        return getResponse(response, null, code);
    }

    protected Response getResponse(List<ENTITY> entities) throws InvocationTargetException, IllegalAccessException {
        Response.Status code = entities.isEmpty() ? Response.Status.NOT_FOUND : Response.Status.OK;
        return getResponse(entities, code);
    }

    protected Response getResponse(List<ENTITY> entities, Response.Status code) throws InvocationTargetException, IllegalAccessException {
        LOGGER.debug("Converting entities : {}", entities);
        List<DTO> dtoList = convertToApiDto(entities);
        LOGGER.debug("Sending dtos : {} with status {}", dtoList, code);
        return getResponse(dtoList, code);
    }

    protected Response getResponse(Object response, String additionalPathInto, Response.Status code) {
        Response.ResponseBuilder webServiceResponseBuilder = Response.status(code);
        webServiceResponseBuilder.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, DELETE, OPTIONS");

        webServiceResponseBuilder.entity(response);

        if (additionalPathInto != null) {
            try {
                String path = uriInfo.getPath();
                if (path.charAt(path.length() - 1) != '/') {
                    path = path + '/';
                }
                webServiceResponseBuilder.location(new URI(path + additionalPathInto));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }

        return webServiceResponseBuilder.build();
    }

    protected List<DTO> convertToApiDto(List<ENTITY> entities) throws InvocationTargetException, IllegalAccessException {
        List<DTO> dtoList = new ArrayList<>(entities.size());
        for (ENTITY entity : entities) {
            dtoList.add(entity.convertAndGet());
        }
        return dtoList;
    }

    protected abstract RequestValidator<DTO, ENTITY> getValidator();
}
