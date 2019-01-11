package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

@Component
public class ProfileAgencyDao {
  private Long agencyId;
  private String name;
  private String nameLc;
  private String address;
  private String suiteApt;
  private String city;
  private String state;
  private String stateAbbr;
  private String zipCode;
  private String phone;
  private String cell;
  private String fax;
  private String email;
  private String emailLc;
  private Enabled emailVerify = Enabled.NOT_ENABLED;

  public Long getAgencyId() {
    return agencyId;
  }

  public void setAgencyId(Long agencyId) {
    this.agencyId = agencyId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNameLc() {
    return nameLc;
  }

  public void setNameLc(String nameLc) {
    this.nameLc = nameLc;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
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
}
