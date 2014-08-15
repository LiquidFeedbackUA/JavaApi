package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.MemberDto;
import com.github.kindrat.liquidfeedback.api.endpoint.dto.MemberRequestDto;
import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.dao.MemberDao;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;
import com.github.kindrat.liquidfeedback.api.validation.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Component
@Path("/member")
public class MemberApi extends AbstractApi<MemberDto, Member> {

    @Autowired
    private MemberDao memberDao;

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
            List<Member> members = memberDao.getMembers(dto);
            return getResponse(members);
        } catch (DalException e) {
            return getResponse(e, INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMemberById(@PathParam("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Member member = memberDao.find(id);
        return getResponse(member);
    }

    @Override
    protected RequestValidator<MemberDto, Member> getValidator() {
        return null;
    }
}
