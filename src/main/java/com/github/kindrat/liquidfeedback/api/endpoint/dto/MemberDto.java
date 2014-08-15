package com.github.kindrat.liquidfeedback.api.endpoint.dto;

import com.github.kindrat.liquidfeedback.api.persistence.entity.Member;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class MemberDto extends BaseDto<Member>
{
    private static final long serialVersionUID = 2736798836292302053L;

    private Integer id;
    private Date created;
    private String inviteCode;
    private Date inviteCodeExpiry;
    private String adminComment;
    private Date activated;
    private Date lastActivity;
    private Date lastLogin;
    private Date lastDelegationCheck;
    private String login;
    private String password;
    private Boolean isLocked;
    private Boolean isActive;
    private Boolean isAdmin;
    private String lang;
    private String notifyEmail;
    private String notifyEmailUnconfirmed;
    private String notifyEmailSecret;
    private Date notifyEmailSecretExpiry;
    private Date notifyEmailLockExpiry;
    private NotifyLevel notifyLevel;
    private Date loginRecoveryExpiry;
    private String passwordResetSecret;
    private Date passwordResetSecretExpiry;
    private String name;
    private String identification;
    private String authentication;
    private String organizationalUnit;
    private String internalPosts;
    private String realName;
    private Date birthday;
    private String address;
    private String email;
    private String xmppAddress;
    private String website;
    private String phone;
    private String mobilePhone;
    private String profession;
    private String externalMemberships;
    private String externalPosts;
    private String formattingEngine;
    private String statement;
    private String textSearchData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public Date getInviteCodeExpiry() {
        return inviteCodeExpiry;
    }

    public void setInviteCodeExpiry(Date inviteCodeExpiry) {
        this.inviteCodeExpiry = inviteCodeExpiry;
    }

    public String getAdminComment() {
        return adminComment;
    }

    public void setAdminComment(String adminComment) {
        this.adminComment = adminComment;
    }

    public Date getActivated() {
        return activated;
    }

    public void setActivated(Date activated) {
        this.activated = activated;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastDelegationCheck() {
        return lastDelegationCheck;
    }

    public void setLastDelegationCheck(Date lastDelegationCheck) {
        this.lastDelegationCheck = lastDelegationCheck;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public String getNotifyEmailUnconfirmed() {
        return notifyEmailUnconfirmed;
    }

    public void setNotifyEmailUnconfirmed(String notifyEmailUnconfirmed) {
        this.notifyEmailUnconfirmed = notifyEmailUnconfirmed;
    }

    public String getNotifyEmailSecret() {
        return notifyEmailSecret;
    }

    public void setNotifyEmailSecret(String notifyEmailSecret) {
        this.notifyEmailSecret = notifyEmailSecret;
    }

    public Date getNotifyEmailSecretExpiry() {
        return notifyEmailSecretExpiry;
    }

    public void setNotifyEmailSecretExpiry(Date notifyEmailSecretExpiry) {
        this.notifyEmailSecretExpiry = notifyEmailSecretExpiry;
    }

    public Date getNotifyEmailLockExpiry() {
        return notifyEmailLockExpiry;
    }

    public void setNotifyEmailLockExpiry(Date notifyEmailLockExpiry) {
        this.notifyEmailLockExpiry = notifyEmailLockExpiry;
    }

    public NotifyLevel getNotifyLevel() {
        return notifyLevel;
    }

    public void setNotifyLevel(NotifyLevel notifyLevel) {
        this.notifyLevel = notifyLevel;
    }

    public Date getLoginRecoveryExpiry() {
        return loginRecoveryExpiry;
    }

    public void setLoginRecoveryExpiry(Date loginRecoveryExpiry) {
        this.loginRecoveryExpiry = loginRecoveryExpiry;
    }

    public String getPasswordResetSecret() {
        return passwordResetSecret;
    }

    public void setPasswordResetSecret(String passwordResetSecret) {
        this.passwordResetSecret = passwordResetSecret;
    }

    public Date getPasswordResetSecretExpiry() {
        return passwordResetSecretExpiry;
    }

    public void setPasswordResetSecretExpiry(Date passwordResetSecretExpiry) {
        this.passwordResetSecretExpiry = passwordResetSecretExpiry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getOrganizationalUnit() {
        return organizationalUnit;
    }

    public void setOrganizationalUnit(String organizationalUnit) {
        this.organizationalUnit = organizationalUnit;
    }

    public String getInternalPosts() {
        return internalPosts;
    }

    public void setInternalPosts(String internalPosts) {
        this.internalPosts = internalPosts;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getXmppAddress() {
        return xmppAddress;
    }

    public void setXmppAddress(String xmppAddress) {
        this.xmppAddress = xmppAddress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getExternalMemberships() {
        return externalMemberships;
    }

    public void setExternalMemberships(String externalMemberships) {
        this.externalMemberships = externalMemberships;
    }

    public String getExternalPosts() {
        return externalPosts;
    }

    public void setExternalPosts(String externalPosts) {
        this.externalPosts = externalPosts;
    }

    public String getFormattingEngine() {
        return formattingEngine;
    }

    public void setFormattingEngine(String formattingEngine) {
        this.formattingEngine = formattingEngine;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getTextSearchData() {
        return textSearchData;
    }

    public void setTextSearchData(String textSearchData) {
        this.textSearchData = textSearchData;
    }

    @Override
    public String toString() {
        return "MemberResponseDto{" +
                "id=" + id +
                ", created=" + created +
                ", inviteCode='" + inviteCode + '\'' +
                ", inviteCodeExpiry=" + inviteCodeExpiry +
                ", adminComment='" + adminComment + '\'' +
                ", activated=" + activated +
                ", lastActivity=" + lastActivity +
                ", lastLogin=" + lastLogin +
                ", lastDelegationCheck=" + lastDelegationCheck +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isLocked=" + isLocked +
                ", isActive=" + isActive +
                ", isAdmin=" + isAdmin +
                ", lang='" + lang + '\'' +
                ", notifyEmail='" + notifyEmail + '\'' +
                ", notifyEmailUnconfirmed='" + notifyEmailUnconfirmed + '\'' +
                ", notifyEmailSecret='" + notifyEmailSecret + '\'' +
                ", notifyEmailSecretExpiry=" + notifyEmailSecretExpiry +
                ", notifyEmailLockExpiry=" + notifyEmailLockExpiry +
                ", notifyLevel=" + notifyLevel +
                ", loginRecoveryExpiry=" + loginRecoveryExpiry +
                ", passwordResetSecret='" + passwordResetSecret + '\'' +
                ", passwordResetSecretExpiry=" + passwordResetSecretExpiry +
                ", name='" + name + '\'' +
                ", identification='" + identification + '\'' +
                ", authentication='" + authentication + '\'' +
                ", organizationalUnit='" + organizationalUnit + '\'' +
                ", internalPosts='" + internalPosts + '\'' +
                ", realName='" + realName + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", xmppAddress='" + xmppAddress + '\'' +
                ", website='" + website + '\'' +
                ", phone='" + phone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", profession='" + profession + '\'' +
                ", externalMemberships='" + externalMemberships + '\'' +
                ", externalPosts='" + externalPosts + '\'' +
                ", formattingEngine='" + formattingEngine + '\'' +
                ", statement='" + statement + '\'' +
                ", textSearchData='" + textSearchData + '\'' +
                '}';
    }

    @Override
    public Member convertAndGet() throws InvocationTargetException, IllegalAccessException {
        Member member = new Member();
        BeanUtils.copyProperties(member, this);
        return member;
    }
}
