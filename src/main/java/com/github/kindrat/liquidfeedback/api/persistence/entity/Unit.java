package com.github.kindrat.liquidfeedback.api.persistence.entity;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.UnitDto;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;

@Entity(name = "Unit")
@Table(name = "unit")
public class Unit extends BaseEntity<UnitDto>
{
   private static final long serialVersionUID = -5153146938729420772L;
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   @Column(name = "parent_id")
   private Integer parentId;
   @Column(name = "active", nullable = false, columnDefinition = "boolean NOT NULL DEFAULT true")
   private Boolean active;
   @Column(name = "name", nullable = false)
   private String name;
   @Column(name = "description", nullable = false, columnDefinition = "text NOT NULL DEFAULT ''::text")
   private String description;
   @Column(name = "member_count")
   private Integer memberCount;
   @Column(name = "text_search_data")
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
      return "Unit{" +
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
   public UnitDto convertAndGet() throws InvocationTargetException, IllegalAccessException
   {
      UnitDto dto = new UnitDto();
      BeanUtils.copyProperties(dto, this);
      return dto;
   }
}
