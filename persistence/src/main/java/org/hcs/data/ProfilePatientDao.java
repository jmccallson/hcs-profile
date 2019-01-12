package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class ProfilePatientDao {
  private Long patientId;
  private String firstName;
  private String firstNameLc;
  private String lastName;
  private String lastNameLc;
  private String medicalRecord;
  private String suite;
  private String address;
  private String city;
  private String state;
  private String zipCode;
  private Enabled veteran = Enabled.UNSET;
  private Timestamp birthDate;
  private Timestamp deathDate;
  private String ssn;
  private String phoneNumber;
  private String cellNumber;
  private String sex;
  private String maritalStatus;
  private String language;
  private String ethnicity;
  private String referringPrimaryDiagnosis;//pulled in from rn notes
  private String codeStatus;
  private String patientLives;
  private String commentType;
  private String comments;
  private Long statusId;//pulled in from somewhere
  private List<ProfileAllergiesDao> profileAllergiesDaos;//not sure where this comes from
  private ProfileEmergencyContactDao profileEmergencyContactDao;
  private ProfileFuneralHomeDao profileFuneralHomeDao;
  private List<ProfileAgencyDao> profileAgencyDaos;
  private List<ProfileReferralDao> profileReferralDaos;
  private List<ProfilePhysicianDao> profilePhysicianDaos;
  private List<ProfileInsuranceDao> profileInsuranceDaos;
  private List<ProfileCahpDao> profileCahpDaos;
  private Timestamp createDate;
  private Enabled enabled = Enabled.UNSET;
  private String image;

  public Long getPatientId() {
    return patientId;
  }

  public void setPatientId(Long patientId) {
    this.patientId = patientId;
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

  public String getMedicalRecord() {
    return medicalRecord;
  }

  public void setMedicalRecord(String medicalRecord) {
    this.medicalRecord = medicalRecord;
  }

  public String getSuite() {
    return suite;
  }

  public void setSuite(String suite) {
    this.suite = suite;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getVeteran() {
    if (veteran != Enabled.UNSET) {
      return veteran.getState();
    }
    return "F";
  }

  public void setVeteran(String veteran) {
    this.veteran = null != veteran ? Enabled.getByValue(veteran) : Enabled.UNSET;
  }

  public Timestamp getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Timestamp birthDate) {
    this.birthDate = birthDate;
  }

  public Timestamp getDeathDate() {
    return deathDate;
  }

  public void setDeathDate(Timestamp deathDate) {
    this.deathDate = deathDate;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getCellNumber() {
    return cellNumber;
  }

  public void setCellNumber(String cellNumber) {
    this.cellNumber = cellNumber;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }

  public String getReferringPrimaryDiagnosis() {
    return referringPrimaryDiagnosis;
  }

  public void setReferringPrimaryDiagnosis(String referringPrimaryDiagnosis) {
    this.referringPrimaryDiagnosis = referringPrimaryDiagnosis;
  }

  public String getCodeStatus() {
    return codeStatus;
  }

  public void setCodeStatus(String codeStatus) {
    this.codeStatus = codeStatus;
  }

  public String getPatientLives() {
    return patientLives;
  }

  public void setPatientLives(String patientLives) {
    this.patientLives = patientLives;
  }

  public String getCommentType() {
    return commentType;
  }

  public void setCommentType(String commentType) {
    this.commentType = commentType;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Long getStatusId() {
    return statusId;
  }

  public void setStatusId(Long statusId) {
    this.statusId = statusId;
  }

  public List<ProfileAllergiesDao> getProfileAllergiesDaos() {
    return profileAllergiesDaos;
  }

  public void setProfileAllergiesDaos(List<ProfileAllergiesDao> profileAllergiesDaos) {
    this.profileAllergiesDaos = profileAllergiesDaos;
  }

  public ProfileEmergencyContactDao getProfileEmergencyContactDao() {
    return profileEmergencyContactDao;
  }

  public void setProfileEmergencyContactDao(ProfileEmergencyContactDao profileEmergencyContactDao) {
    this.profileEmergencyContactDao = profileEmergencyContactDao;
  }

  public ProfileFuneralHomeDao getProfileFuneralHomeDao() {
    return profileFuneralHomeDao;
  }

  public void setProfileFuneralHomeDao(ProfileFuneralHomeDao profileFuneralHomeDao) {
    this.profileFuneralHomeDao = profileFuneralHomeDao;
  }

  public List<ProfileAgencyDao> getProfileAgencyDaos() {
    return profileAgencyDaos;
  }

  public void setProfileAgencyDaos(List<ProfileAgencyDao> profileAgencyDaos) {
    this.profileAgencyDaos = profileAgencyDaos;
  }

  public List<ProfileReferralDao> getProfileReferralDaos() {
    return profileReferralDaos;
  }

  public void setProfileReferralDaos(List<ProfileReferralDao> profileReferralDaos) {
    this.profileReferralDaos = profileReferralDaos;
  }

  public List<ProfilePhysicianDao> getProfilePhysicianDaos() {
    return profilePhysicianDaos;
  }

  public void setProfilePhysicianDaos(List<ProfilePhysicianDao> profilePhysicianDaos) {
    this.profilePhysicianDaos = profilePhysicianDaos;
  }

  public List<ProfileInsuranceDao> getProfileInsuranceDaos() {
    return profileInsuranceDaos;
  }

  public void setProfileInsuranceDaos(List<ProfileInsuranceDao> profileInsuranceDaos) {
    this.profileInsuranceDaos = profileInsuranceDaos;
  }

  public List<ProfileCahpDao> getProfileCahpDaos() {
    return profileCahpDaos;
  }

  public void setProfileCahpDaos(List<ProfileCahpDao> profileCahpDaos) {
    this.profileCahpDaos = profileCahpDaos;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
