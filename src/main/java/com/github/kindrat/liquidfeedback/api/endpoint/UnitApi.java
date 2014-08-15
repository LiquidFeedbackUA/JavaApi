package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.UnitDto;
import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.dao.UnitDao;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Unit;
import com.github.kindrat.liquidfeedback.api.validation.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

@Component
@Path("/unit")
public class UnitApi extends AbstractApi<UnitDto, Unit> {

    @Autowired
    public UnitDao unitDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByIds(@QueryParam("ids") Set<Integer> ids) throws InvocationTargetException, IllegalAccessException {
        try {
            List<Unit> unitList = unitDao.getByIds(ids);
            return getResponse(unitList);
        } catch (DalException e) {
            return getResponse(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected RequestValidator<UnitDto, Unit> getValidator() {
        return null;
    }
}
