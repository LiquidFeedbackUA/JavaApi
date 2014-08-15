package com.github.kindrat.liquidfeedback.api.endpoint.dto;

import com.github.kindrat.liquidfeedback.api.persistence.entity.Unit;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class UnitDto extends BaseDto<Unit>
{
   private static final long serialVersionUID = -9153907234805495039L;
   private Integer id;
   private Integer parentId;
   private Boolean active;
   private String name;
   private String description;
   private Integer memberCount;
   private String textSearchData;

   public Integer getId()
   {
      return id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public Integer getParentId()
   {
      return parentId;
   }

   public void setParentId(Integer parentId)
   {
      this.parentId = parentId;
   }

   public Boolean getActive()
   {
      return active;
   }

   public void setActive(Boolean active)
   {
      this.active = active;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public Integer getMemberCount()
   {
      return memberCount;
   }

   public void setMemberCount(Integer memberCount)
   {
      this.memberCount = memberCount;
   }

   public String getTextSearchData()
   {
      return textSearchData;
   }

   public void setTextSearchData(String textSearchData)
   {
      this.textSearchData = textSearchData;
   }

   @Override
   public String toString()
   {
      return "UnitDto{" +
              "id=" + id +
              ", parentId=" + parentId +
              ", active=" + active +
              ", name='" + name + '\'' +
              ", description='" + description + '\'' +
              ", memberCount=" + memberCount +
              ", textSearchData='" + textSearchData + '\'' +
              '}';
   }

   @Override
   public Unit convertAndGet() throws InvocationTargetException, IllegalAccessException
   {
      Unit unit = new Unit();
      BeanUtils.copyProperties(unit, this);
      return unit;
   }
}
