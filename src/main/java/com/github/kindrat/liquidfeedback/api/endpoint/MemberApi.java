package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.dto.MemberDto;
import com.github.kindrat.liquidfeedback.api.dto.MemberRequestDto;
import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/member")
public class MemberApi extends AbstractApi<MemberDto, Member> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembersByCriteria(
            @QueryParam("ids") List<Integer> ids,
            @QueryParam("active") Boolean useActive,
            @QueryParam("textSearch") String textSearch,
            @QueryParam("useNameOrder") Boolean useNameOrder,
            @QueryParam("useCreatedOrder") Boolean useCreatedOrder
    ) throws InvocationTargetException, IllegalAccessException {
        try {
            MemberRequestDto dto = new MemberRequestDto(new HashSet<>(ids), textSearch, useActive, useNameOrder, useCreatedOrder);
            List<Member> members = appContext.memberDao.getMembers(dto);
            return getResponse(members);
        } catch (DalException e) {
            return getResponse(null, INTERNAL_SERVER_ERROR);
        }
    }
}
