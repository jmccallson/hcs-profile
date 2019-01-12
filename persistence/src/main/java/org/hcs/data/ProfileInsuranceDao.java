package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ProfileInsuranceDao {
  private Long insuranceId;
  private String name;
  private String address;
  private String suiteApt;
  private String city;
  private String state;
  private String stateAbbr;
  private String zipCode;
  private String phone;
  private String type;
  private String authorized;
  private String category;
  private Timestamp dateFrom;
  private Timestamp dateTo;
  private String groupNumber;
  private String groupName;
  private String policyNumber;
  private String eligibility;
  private Enabled insuranceVerify = Enabled.UNSET;
  private Enabled isPrimary = Enabled.UNSET;
  private String comments;
  private Enabled enabled = Enabled.UNSET;

  public Long getInsuranceId() {
    return insuranceId;
  }

  public void setInsuranceId(Long insuranceId) {
    this.insuranceId = insuranceId;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getAuthorized() {
    return authorized;
  }

  public void setAuthorized(String authorized) {
    this.authorized = authorized;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Timestamp getDateFrom() {
    return dateFrom;
  }

  public void setDateFrom(Timestamp dateFrom) {
    this.dateFrom = dateFrom;
  }

  public Timestamp getDateTo() {
    return dateTo;
  }

  public void setDateTo(Timestamp dateTo) {
    this.dateTo = dateTo;
  }

  public String getGroupNumber() {
    return groupNumber;
  }

  public void setGroupNumber(String groupNumber) {
    this.groupNumber = groupNumber;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public String getEligibility() {
    return eligibility;
  }

  public void setEligibility(String eligibility) {
    this.eligibility = eligibility;
  }

  public String getInsuranceVerify() {
    if (insuranceVerify != Enabled.UNSET) {
      return insuranceVerify.getState();
    }
    return "F";
  }

  public void setInsuranceVerify(String insuranceVerify) {
    this.insuranceVerify = null != insuranceVerify ? Enabled.getByValue(insuranceVerify) : Enabled.UNSET;
  }

  public String getIsPrimary() {
    if (isPrimary != Enabled.UNSET) {
      return isPrimary.getState();
    }
    return "F";
  }

  public void setIsPrimary(String isPrimary) {
    this.isPrimary = null != isPrimary ? Enabled.getByValue(isPrimary) : Enabled.UNSET;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
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
