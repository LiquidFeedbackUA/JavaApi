package com.github.kindrat.liquidfeedback.api.persistence.dao;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.MemberRequestDto;
import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Component
public class MemberDao extends AbstractJpaDao<Member> {

    public MemberDao() {
        setClazz(Member.class);
    }

    public List<Member> getMembers(MemberRequestDto dto) throws DalException {
        try {
            TypedQuery<Member> query = getEntityManager().createQuery(buildQuery(dto), Member.class);
            return query.getResultList();
        }catch (Exception e){
            throw new DalException(e);
        }
    }

    private String buildQuery(MemberRequestDto dto)
    {
        final StringBuilder query = new StringBuilder();
        query.append("select m from Member m where m.id in (").append(StringUtils.join(dto.getIds(), ",")).append(")");
        if (dto.getSearchActive())
            query.append("and m.isActive = true or m.isActive = null ");
        else
            query.append("and m.isActive = false");
        if (isNotBlank(dto.getTextSearch()))
            query.append("and to_tsvector(m.textSearchData) @@ to_tsquery(").append(dto.getTextSearch()).append(")");
        if (dto.getUseNameOrder())
            query.append("order by m.name ");
        if (dto.getUseCreatedOrder())
            query.append(", m.created desc ");

        return query.toString();
    }
}
