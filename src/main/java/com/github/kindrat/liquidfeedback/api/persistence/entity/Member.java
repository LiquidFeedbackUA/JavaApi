package com.github.kindrat.liquidfeedback.api.persistence.entity;

import com.github.kindrat.liquidfeedback.api.endpoint.dto.NotifyLevel;
import com.github.kindrat.liquidfeedback.api.endpoint.dto.MemberDto;
import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Entity(name = "Member")
@Table(name = "member")
public class Member extends BaseEntity<MemberDto> {

    private static final long serialVersionUID = 6441850877931072291L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Column(name = "invite_code", nullable = false, unique = true)
    private String inviteCode;
    @Column(name = "invite_code_expiry")
    @Temporal(TemporalType.DATE)
    private Date inviteCodeExpiry;
    @Column(name = "admin_comment")
    private String adminComment;
    @Column(name = "activated")
    @Temporal(TemporalType.DATE)
    private Date activated;
    @Column(name = "last_activity")
    @Temporal(TemporalType.DATE)
    private Date lastActivity;
    @Column(name = "last_login")
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
    @Column(name = "last_delegation_check")
    @Temporal(TemporalType.DATE)
    private Date lastDelegationCheck;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "locked", nullable = false)
    private Boolean isLocked;
    @Column(name = "active", nullable = false)
    private Boolean isActive;
    @Column(name = "admin", nullable = false)
    private Boolean isAdmin;
    @Column(name = "lang")
    private String lang;
    @Column(name = "notify_email")
    private String notifyEmail;
    @Column(name = "notify_email_unconfirmed")
    private String notifyEmailUnconfirmed;
    @Column(name = "notify_email_secret")
    private String notifyEmailSecret;
    @Column(name = "notify_email_secret_expiry", unique = true)
    @Temporal(TemporalType.DATE)
    private Date notifyEmailSecretExpiry;
    @Column(name = "notify_email_lock_expiry")
    @Temporal(TemporalType.DATE)
    private Date notifyEmailLockExpiry;
    @Column(name = "notify_level")
    @Enumerated(EnumType.STRING)
    private NotifyLevel notifyLevel;
    @Column(name = "login_recovery_expiry")
    @Temporal(TemporalType.DATE)
    private Date loginRecoveryExpiry;
    @Column(name = "password_reset_secret")
    private String passwordResetSecret;
    @Column(name = "password_reset_secret_expiry", unique = true)
    @Temporal(TemporalType.DATE)
    private Date passwordResetSecretExpiry;
    @Column(name = "name", nullable = true, unique = true)
    private String name;
    @Column(name = "identification", nullable = true, unique = true)
    private String identification;
    @Column(name = "authentication")
    private String authentication;
    @Column(name = "organizational_unit")
    private String organizationalUnit;
    @Column(name = "internal_posts")
    private String internalPosts;
    @Column(name = "realname")
    private String realName;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "xmpp_address")
    private String xmppAddress;
    @Column(name = "website")
    private String website;
    @Column(name = "phone")
    private String phone;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "profession")
    private String profession;
    @Column(name = "external_memberships")
    private String externalMemberships;
    @Column(name = "external_posts")
    private String externalPosts;
    @Column(name = "formatting_engine")
    private String formattingEngine;
    @Column(name = "statement")
    private String statement;
    @Column(name = "text_search_data")
    private String textSearchData;//TODO tsvector

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
        return "Member{" +
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

    public MemberDto convertAndGet() throws InvocationTargetException, IllegalAccessException {
        MemberDto dto = new MemberDto();
        BeanUtils.copyProperties(dto, this);
        return dto;
    }
}
