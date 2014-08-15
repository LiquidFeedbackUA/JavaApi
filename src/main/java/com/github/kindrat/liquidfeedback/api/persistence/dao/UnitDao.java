package com.github.kindrat.liquidfeedback.api.persistence.dao;

import com.github.kindrat.liquidfeedback.api.exceptions.DalException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Unit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Component
public class UnitDao extends AbstractJpaDao<Unit>
{
   public UnitDao()
   {
      setClazz(Unit.class);
   }

   public List<Unit> getByIds(Set<Integer> ids) throws DalException
   {
      try {
         TypedQuery<Unit> query = getEntityManager()
                 .createQuery("select u from Unit u where u.id in (" + StringUtils.join(ids, ",") + ")", Unit.class);
         return query.getResultList();
      }catch (Exception e)
      {
         throw new DalException(e);
      }
   }
}
