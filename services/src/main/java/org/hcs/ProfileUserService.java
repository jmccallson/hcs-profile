package org.hcs;

import org.hcs.entities.ProfileUserEntity;
import org.hcs.repositories.ProfileUserRepo;
import org.springframework.stereotype.Component;

@Component
public class ProfileUserService {
  private ProfileUserRepo profileUserRepo;
  public ProfileUserService(ProfileUserRepo profileUserRepo){
    this.profileUserRepo = profileUserRepo;
  }
  public ProfileUserEntity create(String sessionId, ProfileUserEntity profileUserEntity){
    Long userId = profileUserRepo.create(profileUserEntity);
    profileUserEntity.setUserId(userId);
    return profileUserEntity;
  }

}
