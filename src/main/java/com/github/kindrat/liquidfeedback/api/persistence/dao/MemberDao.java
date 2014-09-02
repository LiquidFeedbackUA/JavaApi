package com.github.kindrat.liquidfeedback.api.persistence.dao;

import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface MemberDao extends JpaRepository<Member, Long> {
    //id in set
    public List<Member> findByIdIn(Set<Long> ids);
    public List<Member> findByIdIn(Set<Long> ids, Sort sort);
    //active false
    public List<Member> findByIsActiveFalse(Pageable pageable);
    //active true or null
    public List<Member> findByIsActiveTrueOrIsActiveIsNull(Pageable pageable);
    //id in set and active false
    public List<Member> findByIdInAndIsActiveFalse(Set<Long> ids);
    public List<Member> findByIdInAndIsActiveFalse(Set<Long> ids, Sort sort);
    //id in set and active true or null
    public List<Member> findByIdInAndIsActiveTrueOrIsActiveIsNull(Set<Long> ids);
    public List<Member> findByIdInAndIsActiveTrueOrIsActiveIsNull(Set<Long> ids, Sort sort);
}
