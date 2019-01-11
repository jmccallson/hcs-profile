package org.hcs.data;

import org.hcs.managers.Enabled;
import org.springframework.stereotype.Component;

@Component
public class ProfileAllergiesDao {
  private Long allergyId;
  private String name;
  private Enabled enabled = Enabled.UNSET;

  public Long getAllergyId() {
    return allergyId;
  }

  public void setAllergyId(Long allergyId) {
    this.allergyId = allergyId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
