package com.github.kindrat.liquidfeedback.api.validation;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.MemberDto;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberValidator extends RequestValidator<MemberDto, Member> {
}
