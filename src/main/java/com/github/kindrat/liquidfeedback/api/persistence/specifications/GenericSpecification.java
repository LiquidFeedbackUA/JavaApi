package com.github.kindrat.liquidfeedback.api.persistence.specifications;

import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

public class GenericSpecification<ENTITY extends BaseEntity> {
    public static <ENTITY> Specification<ENTITY> textSearchAcceptable(final String textSearch) {
        return new Specification<ENTITY>() {
            public Predicate toPredicate(Root<ENTITY> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.isTrue(
                        builder.function(
                                "fts",
                                Boolean.TYPE,
                                root.<String>get("textSearch"),
                                builder.literal(textSearch)));
            }
        };
    }
}
