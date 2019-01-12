package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

@Component
public class ProfileFuneralHomeDao {
  private Long funeralId;
  private String name;
  private String address;
  private String suiteApt;
  private String city;
  private String state;
  private String stateAbbr;
  private String zipCode;
  private String phone;
  private String contact;
  private String county;
  private String dischargeReason;
  private Enabled enabled = Enabled.UNSET;

  public Long getFuneralId() {
    return funeralId;
  }

  public void setFuneralId(Long funeralId) {
    this.funeralId = funeralId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getDischargeReason() {
    return dischargeReason;
  }

  public void setDischargeReason(String dischargeReason) {
    this.dischargeReason = dischargeReason;
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
