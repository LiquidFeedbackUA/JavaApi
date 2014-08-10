package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.AppContext;
import com.github.kindrat.liquidfeedback.api.util.Convertible;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractApi<Dto extends Serializable, Entity extends Convertible<Dto>> {

    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractApi.class);

    @Inject
    protected AppContext appContext;

    @Context
    private UriInfo uriInfo;

    @PostConstruct
    private void setUp() {
        //TODO
    }

    protected Response getResponse(Object response, Response.Status code) {
        return getResponse(response, null, code);
    }

    protected Response getResponse(List<Entity> entities, Response.Status code) throws InvocationTargetException, IllegalAccessException {
        return getResponse(convertToApiDto(entities), code);
    }

    protected Response getResponse(List<Entity> entities) throws InvocationTargetException, IllegalAccessException {
        List<Dto> dtoList = convertToApiDto(entities);
        Response.Status code = dtoList.isEmpty() ? Response.Status.NOT_FOUND : Response.Status.OK;
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

    protected List<Dto> convertToApiDto(List<Entity> entities) throws InvocationTargetException, IllegalAccessException {
        List<Dto> dtoList = new ArrayList<>(entities.size());
        for (Entity entity : entities) {
            dtoList.add(entity.convertAndGet());
        }
        return dtoList;
    }
}
