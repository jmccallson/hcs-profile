package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

@Component
public class ProfilePhysicianDao {
  private Long physicianId;
  private String firstName;
  private String firstNameLc;
  private String lastName;
  private String lastNameLc;
  private String suiteApt;
  private String city;
  private String state;
  private String stateAbbr;
  private String zipCode;
  private String phone;
  private String pecos;
  private String upin;
  private String npi;
  private String protocol;
  private Long physicianTypeId;
  private Enabled enabled = Enabled.UNSET;

  public Long getPhysicianId() {
    return physicianId;
  }

  public void setPhysicianId(Long physicianId) {
    this.physicianId = physicianId;
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

  public String getPecos() {
    return pecos;
  }

  public void setPecos(String pecos) {
    this.pecos = pecos;
  }

  public String getUpin() {
    return upin;
  }

  public void setUpin(String upin) {
    this.upin = upin;
  }

  public String getNpi() {
    return npi;
  }

  public void setNpi(String npi) {
    this.npi = npi;
  }

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  public Long getPhysicianTypeId() {
    return physicianTypeId;
  }

  public void setPhysicianTypeId(Long physicianTypeId) {
    this.physicianTypeId = physicianTypeId;
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
