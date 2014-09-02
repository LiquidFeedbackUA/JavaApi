package com.github.kindrat.liquidfeedback.api.service;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.MemberDto;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityConversionException;
import com.github.kindrat.liquidfeedback.api.exceptions.EntityNotFoundException;
import com.github.kindrat.liquidfeedback.api.persistence.dao.MemberDao;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;
import com.github.kindrat.liquidfeedback.api.validation.MemberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class MemberService extends AbstractService<MemberDto, Member> {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberValidator validator;

    @Override
    public List<MemberDto> getPageStartingWithId(PageRequest request) throws EntityConversionException {
        return convertToApiDto(memberDao.findAll(request));
    }

    @Override
    public MemberDto getById(Long id) throws EntityNotFoundException, EntityConversionException {
        Member member = memberDao.findOne(id);
        validator.validateEntity(member);
        return member.convertAndGet();
    }
}
