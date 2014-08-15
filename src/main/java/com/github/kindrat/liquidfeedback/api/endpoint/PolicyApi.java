package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.PolicyDto;
import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.dao.PolicyDao;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Policy;
import com.github.kindrat.liquidfeedback.api.validation.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

@Component
@Path("/policy")
public class PolicyApi extends AbstractApi<PolicyDto, Policy> {

    @Autowired
    private PolicyDao policyDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoliciesWithIds(@QueryParam("ids") Set<Integer> ids) throws InvocationTargetException, IllegalAccessException {
        try
        {
            List<Policy> policyList = policyDao.getByIds(ids);
            return getResponse(policyList);
        } catch (DalException e) {
            return getResponse(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPolicyById(@PathParam("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Policy policy = policyDao.find(id);
        return getResponse(policy);
    }

    @Override
    protected RequestValidator<PolicyDto, Policy> getValidator() {
        return null;
    }
}
