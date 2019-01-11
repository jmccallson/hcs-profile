package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;


@Component
public class ProfileUserDao {
  private Long userId;
  private String loginName;
  private String loginNameLc;
  private String firstName;
  private String firstNameLc;
  private String lastName;
  private String lastNameLc;
  private String jobTitle;
  private String accountType;
  private Timestamp createDate;
  private Timestamp updateDate;
  private Enabled enabled= Enabled.UNSET;
  private Long userTypeId;
  private String visibility;
  private String onCall;
  private String displayName;
  private List<ProfilePatientDao> profilePatientDaos;
  private List<ProfileAgencyDao> profileAgencyDaos;
  private List<ProfileFormsDao> profileFormsDaos;

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginNameLc() {
    return loginNameLc;
  }

  public void setLoginNameLc(String loginNameLc) {
    this.loginNameLc = loginNameLc;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstNameLc() {
    return firstNameLc;
  }

  public void setFirstNameLc(String firstNameLc) {
    this.firstNameLc = firstNameLc;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastNameLc() {
    return lastNameLc;
  }

  public void setLastNameLc(String lastNameLc) {
    this.lastNameLc = lastNameLc;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public Timestamp getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Timestamp updateDate) {
    this.updateDate = updateDate;
  }

  public String getEnabled() {
    if (enabled != Enabled.UNSET) {
      return enabled.getState();
    }
    return "F";
  }

  public void setEnabled(String enabled) {
    this.enabled = null != enabled ? Enabled.getByValue(enabled) : Enabled.UNSET;
  }

  public Long getUserTypeId() {
    return userTypeId;
  }

  public void setUserTypeId(Long userTypeId) {
    this.userTypeId = userTypeId;
  }

  public String getVisibility() {
    return visibility;
  }

  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  public String getOnCall() {
    return onCall;
  }

  public void setOnCall(String onCall) {
    this.onCall = onCall;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public List<ProfilePatientDao> getProfilePatientDaos() {
    return profilePatientDaos;
  }

  public void setProfilePatientDaos(List<ProfilePatientDao> profilePatientDaos) {
    this.profilePatientDaos = profilePatientDaos;
  }

  public List<ProfileAgencyDao> getProfileAgencyDaos() {
    return profileAgencyDaos;
  }

  public void setProfileAgencyDaos(List<ProfileAgencyDao> profileAgencyDaos) {
    this.profileAgencyDaos = profileAgencyDaos;
  }

  public List<ProfileFormsDao> getProfileFormsDaos() {
    return profileFormsDaos;
  }

  public void setProfileFormsDaos(List<ProfileFormsDao> profileFormsDaos) {
    this.profileFormsDaos = profileFormsDaos;
  }
}
