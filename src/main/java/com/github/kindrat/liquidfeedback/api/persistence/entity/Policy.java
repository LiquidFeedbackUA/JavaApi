package com.github.kindrat.liquidfeedback.api.persistence.entity;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.PolicyDto;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.Type;
import org.joda.time.Period;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;

@Entity(name = "Policy")
@Table(name = "policy")
public class Policy extends BaseEntity<PolicyDto> {

    private static final long serialVersionUID = 5606472168500346972L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private Integer index;
    @Column(nullable = false, columnDefinition = "boolean NOT NULL DEFAULT true")
    private Boolean active;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, columnDefinition = "text NOT NULL DEFAULT ''::text")
    private String description;
    @Column(nullable = false, columnDefinition = "boolean NOT NULL DEFAULT false")
    private Boolean polling;
    @Column(name = "admission_time")
    @Type(type="com.github.kindrat.liquidfeedback.api.persistence.types.Interval")
    private Period admissionTime;
    @Column(name = "discussion_time")
    @Type(type="com.github.kindrat.liquidfeedback.api.persistence.types.Interval")
    private Period discussionTime;
    @Column(name = "verification_time")
    @Type(type="com.github.kindrat.liquidfeedback.api.persistence.types.Interval")
    private Period verificationTime;
    @Column(name = "voting_time")
    @Type(type="com.github.kindrat.liquidfeedback.api.persistence.types.Interval")
    private Period votingTime;
    @Column(name = "issue_quorum_num")
    private Integer issueQuorumNum;
    @Column(name = "issue_quorum_den")
    private Integer issueQuorumDen;
    @Column(name = "initiative_quorum_num", nullable = false)
    private Integer initiativeQuorumNum;
    @Column(name = "initiative_quorum_den", nullable = false)
    private Integer initiativeQuorumDen;
    @Column(name = "direct_majority_num", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 1")
    private Integer directMajorityNum;
    @Column(name = "direct_majority_den", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 2")
    private Integer directMajorityDen;
    @Column(name = "direct_majority_strict", nullable = false, columnDefinition = "boolean NOT NULL DEFAULT true")
    private Boolean directMajorityStrict;
    @Column(name = "direct_majority_positive", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 0")
    private Integer directMajorityPositive;
    @Column(name = "direct_majority_non_negative", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 0")
    private Integer directMajorityNonNegative;
    @Column(name = "indirect_majority_num", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 1")
    private Integer indirectMajorityNum;
    @Column(name = "indirect_majority_den", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 2")
    private Integer indirectMajorityDen;
    @Column(name = "indirect_majority_strict", nullable = false, columnDefinition = "boolean NOT NULL DEFAULT true")
    private Boolean indirectMajorityStrict;
    @Column(name = "indirect_majority_positive", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 0")
    private Integer indirectMajorityPositive;
    @Column(name = "indirect_majority_non_negative", nullable = false, columnDefinition = "integer NOT NULL DEFAULT 0")
    private Integer indirectMajorityNonNegative;
    @Column(name = "no_reverse_beat_path", nullable = false, columnDefinition = "boolean NOT NULL DEFAULT false")
    private Boolean noReverseBeatPath;
    @Column(name = "no_multistage_majority", nullable = false, columnDefinition = "boolean NOT NULL DEFAULT false")
    private Boolean noMultistageMajority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPolling() {
        return polling;
    }

    public void setPolling(Boolean polling) {
        this.polling = polling;
    }

    public Period getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Period admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Period getDiscussionTime() {
        return discussionTime;
    }

    public void setDiscussionTime(Period discussionTime) {
        this.discussionTime = discussionTime;
    }

    public Period getVerificationTime() {
        return verificationTime;
    }

    public void setVerificationTime(Period verificationTime) {
        this.verificationTime = verificationTime;
    }

    public Period getVotingTime() {
        return votingTime;
    }

    public void setVotingTime(Period votingTime) {
        this.votingTime = votingTime;
    }

    public Integer getIssueQuorumNum() {
        return issueQuorumNum;
    }

    public void setIssueQuorumNum(Integer issueQuorumNum) {
        this.issueQuorumNum = issueQuorumNum;
    }

    public Integer getIssueQuorumDen() {
        return issueQuorumDen;
    }

    public void setIssueQuorumDen(Integer issueQuorumDen) {
        this.issueQuorumDen = issueQuorumDen;
    }

    public Integer getInitiativeQuorumNum() {
        return initiativeQuorumNum;
    }

    public void setInitiativeQuorumNum(Integer initiativeQuorumNum) {
        this.initiativeQuorumNum = initiativeQuorumNum;
    }

    public Integer getInitiativeQuorumDen() {
        return initiativeQuorumDen;
    }

    public void setInitiativeQuorumDen(Integer initiativeQuorumDen) {
        this.initiativeQuorumDen = initiativeQuorumDen;
    }

    public Integer getDirectMajorityNum() {
        return directMajorityNum;
    }

    public void setDirectMajorityNum(Integer directMajorityNum) {
        this.directMajorityNum = directMajorityNum;
    }

    public Integer getDirectMajorityDen() {
        return directMajorityDen;
    }

    public void setDirectMajorityDen(Integer directMajorityDen) {
        this.directMajorityDen = directMajorityDen;
    }

    public Boolean getDirectMajorityStrict() {
        return directMajorityStrict;
    }

    public void setDirectMajorityStrict(Boolean directMajorityStrict) {
        this.directMajorityStrict = directMajorityStrict;
    }

    public Integer getDirectMajorityPositive() {
        return directMajorityPositive;
    }

    public void setDirectMajorityPositive(Integer directMajorityPositive) {
        this.directMajorityPositive = directMajorityPositive;
    }

    public Integer getDirectMajorityNonNegative() {
        return directMajorityNonNegative;
    }

    public void setDirectMajorityNonNegative(Integer directMajorityNonNegative) {
        this.directMajorityNonNegative = directMajorityNonNegative;
    }

    public Integer getIndirectMajorityNum() {
        return indirectMajorityNum;
    }

    public void setIndirectMajorityNum(Integer indirectMajorityNum) {
        this.indirectMajorityNum = indirectMajorityNum;
    }

    public Integer getIndirectMajorityDen() {
        return indirectMajorityDen;
    }

    public void setIndirectMajorityDen(Integer indirectMajorityDen) {
        this.indirectMajorityDen = indirectMajorityDen;
    }

    public Boolean getIndirectMajorityStrict() {
        return indirectMajorityStrict;
    }

    public void setIndirectMajorityStrict(Boolean indirectMajorityStrict) {
        this.indirectMajorityStrict = indirectMajorityStrict;
    }

    public Integer getIndirectMajorityPositive() {
        return indirectMajorityPositive;
    }

    public void setIndirectMajorityPositive(Integer indirectMajorityPositive) {
        this.indirectMajorityPositive = indirectMajorityPositive;
    }

    public Integer getIndirectMajorityNonNegative() {
        return indirectMajorityNonNegative;
    }

    public void setIndirectMajorityNonNegative(Integer indirectMajorityNonNegative) {
        this.indirectMajorityNonNegative = indirectMajorityNonNegative;
    }

    public Boolean getNoReverseBeatPath() {
        return noReverseBeatPath;
    }

    public void setNoReverseBeatPath(Boolean noReverseBeatPath) {
        this.noReverseBeatPath = noReverseBeatPath;
    }

    public Boolean getNoMultistageMajority() {
        return noMultistageMajority;
    }

    public void setNoMultistageMajority(Boolean noMultistageMajority) {
        this.noMultistageMajority = noMultistageMajority;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", index=" + index +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", polling=" + polling +
                ", admissionTime=" + admissionTime +
                ", discussionTime=" + discussionTime +
                ", verificationTime=" + verificationTime +
                ", votingTime=" + votingTime +
                ", issueQuorumNum=" + issueQuorumNum +
                ", issueQuorumDen=" + issueQuorumDen +
                ", initiativeQuorumNum=" + initiativeQuorumNum +
                ", initiativeQuorumDen=" + initiativeQuorumDen +
                ", directMajorityNum=" + directMajorityNum +
                ", directMajorityDen=" + directMajorityDen +
                ", directMajorityStrict=" + directMajorityStrict +
                ", directMajorityPositive=" + directMajorityPositive +
                ", directMajorityNonNegative=" + directMajorityNonNegative +
                ", indirectMajorityNum=" + indirectMajorityNum +
                ", indirectMajorityDen=" + indirectMajorityDen +
                ", indirectMajorityStrict=" + indirectMajorityStrict +
                ", indirectMajorityPositive=" + indirectMajorityPositive +
                ", indirectMajorityNonNegative=" + indirectMajorityNonNegative +
                ", noReverseBeatPath=" + noReverseBeatPath +
                ", noMultistageMajority=" + noMultistageMajority +
                '}';
    }

    public PolicyDto convertAndGet() throws InvocationTargetException, IllegalAccessException {
        PolicyDto dto = new PolicyDto();
        BeanUtils.copyProperties(dto, this);
        return dto;
    }
}
