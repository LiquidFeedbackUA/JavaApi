package com.github.kindrat.liquidfeedback.api.persistence.dao;

import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Policy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Component
public class PolicyDao extends AbstractJpaDao<Policy> {

    public PolicyDao() {
        setClazz(Policy.class);
    }

    public List<Policy> getByIds(Set<Integer> ids) throws DalException {
        try {
            TypedQuery<Policy> query = getEntityManager()
                    .createQuery("select p from Policy p where p.id in (" + StringUtils.join(ids, ",") + ")", Policy.class);
            return query.getResultList();
        }catch (Exception e)
        {
            throw new DalException(e);
        }
    }
}
