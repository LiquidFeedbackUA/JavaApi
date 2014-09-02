package com.github.kindrat.liquidfeedback.api.endpoint.dto;

import com.github.kindrat.liquidfeedback.api.exceptions.EntityConversionException;
import com.github.kindrat.liquidfeedback.api.persistence.entity.Policy;
import com.github.kindrat.liquidfeedback.api.util.ConvertUtil;
import org.joda.time.Period;

public class PolicyDto extends BaseDto<Policy> {
    private static final long serialVersionUID = -1854247019203052795L;

    private Integer id;
    private Integer index;
    private Boolean active;
    private String name;
    private String description;
    private Boolean polling;
    private Period admissionTime;
    private Period discussionTime;
    private Period verificationTime;
    private Period votingTime;
    private Integer issueQuorumNum;
    private Integer issueQuorumDen;
    private Integer initiativeQuorumNum;
    private Integer initiativeQuorumDen;
    private Integer directMajorityNum;
    private Integer directMajorityDen;
    private Boolean directMajorityStrict;
    private Integer directMajorityPositive;
    private Integer directMajorityNonNegative;
    private Integer indirectMajorityNum;
    private Integer indirectMajorityDen;
    private Boolean indirectMajorityStrict;
    private Integer indirectMajorityPositive;
    private Integer indirectMajorityNonNegative;
    private Boolean noReverseBeatPath;
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
        return "PolicyResponseDto{" +
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

    @Override
    public Policy convertAndGet() throws EntityConversionException {
        return ConvertUtil.convert(this, Policy.class);
    }
}
