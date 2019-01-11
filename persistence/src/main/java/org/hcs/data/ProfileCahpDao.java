package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

@Component
public class ProfileCahpDao {
  private Long cahpId;
  private String firstName;
  private String firstNameLc;
  private String lastName;
  private String lastNameLc;
  private String middleName;
  private String middleNameLc;
  private String suiteApt;
  private String city;
  private String state;
  private String stateAbbr;
  private String zipCode;
  private String phone;
  private String cell;
  private String email;
  private String emailLc;
  private Enabled emailVerify = Enabled.NOT_ENABLED;
  private String lang;
  private String relationship;
  private Enabled enabled = Enabled.UNSET;

  public Long getCahpId() {
    return cahpId;
  }

  public void setCahpId(Long cahpId) {
    this.cahpId = cahpId;
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

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getMiddleNameLc() {
    return middleNameLc;
  }

  public void setMiddleNameLc(String middleNameLc) {
    this.middleNameLc = middleNameLc;
  }

  public String getSuiteApt() {
    return suiteApt;
  }

  public void setSuiteApt(String suiteApt) {
    this.suiteApt = suiteApt;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getStateAbbr() {
    return stateAbbr;
  }

  public void setStateAbbr(String stateAbbr) {
    this.stateAbbr = stateAbbr;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCell() {
    return cell;
  }

  public void setCell(String cell) {
    this.cell = cell;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailLc() {
    return emailLc;
  }

  public void setEmailLc(String emailLc) {
    this.emailLc = emailLc;
  }

  public String getEmailVerify() {
    if (emailVerify != Enabled.UNSET) {
      return emailVerify.getState();
    }
    return "F";
  }

  public void setEmailVerify(String emailVerify) {
    this.emailVerify = null != emailVerify ? Enabled.getByValue(emailVerify) : Enabled.UNSET;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
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
}
