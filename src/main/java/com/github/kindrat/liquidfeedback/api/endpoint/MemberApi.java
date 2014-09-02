package com.github.kindrat.liquidfeedback.api.endpoint;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.MemberDto;
import com.github.kindrat.liquidfeedback.api.endpoint.dto.OrderType;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityConversionException;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityNotFoundException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;
import com.github.kindrat.liquidfeedback.api.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

@Component
@Path("/member")
public class MemberApi extends AbstractApi<MemberDto, Member> {

    @Autowired
    private MemberService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @QueryParam("page") Integer page,
            @QueryParam("pageSize") Short pageSize
    ) throws EntityConversionException {
        List<MemberDto> members = service.getPageStartingWithId(new PageRequest(page, pageSize));
        return getResponse(members);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @QueryParam("textSearch") String textSearch,
            @QueryParam("page") Integer page,
            @QueryParam("pageSize") Short pageSize
    ) throws EntityConversionException {
        return getResponse(NOT_FOUND);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMemberById(@PathParam("id") Long id) throws EntityConversionException {
        try {
            MemberDto member = service.getById(id);
            return getResponse(member, OK);
        } catch (EntityNotFoundException e) {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/batch/{batch}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(@PathParam("batch") Set<Long> ids) {
        return getResponse(NOT_FOUND);
    }

    @GET
    @Path("/batch/{batch}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("batch") Set<Long> ids,
            @QueryParam("textSearch") String textSearch
            ) {
        return getResponse(NOT_FOUND);
    }

    @GET
    @Path("/active/{active}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("active") Boolean isActive,
            @QueryParam("page") Integer page,
            @QueryParam("pageSize") Short pageSize
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/active/{active}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("active") Boolean isActive,
            @QueryParam("textSearch") String textSearch
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/batch/{batch}/active/{active}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("batch") Set<Long> ids,
            @PathParam("active") Boolean isActive
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/batch/{batch}/active/{active}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("batch") Set<Long> ids,
            @PathParam("active") Boolean isActive,
            @QueryParam("textSearch") String textSearch
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/order/{order}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("order") OrderType orderType,
            @QueryParam("page") Integer page,
            @QueryParam("pageSize") Short pageSize
    ) {
        return getResponse(NOT_FOUND);
    }

    @GET
    @Path("/order/{order}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("order") OrderType orderType,
            @QueryParam("textSearch") String textSearch
    ) {
        return getResponse(NOT_FOUND);
    }

    @GET
    @Path("/batch/{batch}/order/{order}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("batch") Set<Long> ids,
            @PathParam("order") OrderType orderType
    ) {
        return getResponse(NOT_FOUND);
    }

    @GET
    @Path("/batch/{batch}/order/{order}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("batch") Set<Long> ids,
            @PathParam("order") OrderType orderType,
            @QueryParam("textSearch") String textSearch
    ) {
        return getResponse(NOT_FOUND);
    }

    @GET
    @Path("/active/{active}/order/{order}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("active") Boolean isActive,
            @PathParam("order") OrderType orderType,
            @QueryParam("page") Integer page,
            @QueryParam("pageSize") Short pageSize
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/active/{active}/order/{order}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("active") Boolean isActive,
            @PathParam("order") OrderType orderType,
            @QueryParam("textSearch") String textSearch
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/batch/{batch}/active/{active}/order/{order}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("batch") Set<Long> ids,
            @PathParam("active") Boolean isActive,
            @PathParam("order") OrderType orderType
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }

    @GET
    @Path("/batch/{batch}/active/{active}/order/{order}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMembers(
            @PathParam("batch") Set<Long> ids,
            @PathParam("active") Boolean isActive,
            @PathParam("order") OrderType orderType,
            @QueryParam("textSearch") String textSearch
    ) {
        if (isActive) {
            return getResponse(NOT_FOUND);
        } else {
            return getResponse(NOT_FOUND);
        }
    }
}
