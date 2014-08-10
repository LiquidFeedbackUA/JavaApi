package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.dto.PolicyDto;
import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Policy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

@Path("/policy")
public class PolicyApi extends AbstractApi<PolicyDto, Policy> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoliciesWithIds(@QueryParam("ids") Set<Integer> ids) throws InvocationTargetException, IllegalAccessException {
        try
        {
            List<Policy> policyList = appContext.policyDao.getByIds(ids);
            return getResponse(policyList);
        } catch (DalException e) {
            return getResponse(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
