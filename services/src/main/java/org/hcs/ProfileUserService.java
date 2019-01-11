package org.hcs;

import org.hcs.data.ProfileUserDao;
import org.hcs.exceptions.ProfileAlreadyExistsException;
import org.hcs.repositories.ProfileUserRepository;
import org.springframework.stereotype.Component;

@Component
public class ProfileUserService {
  private ProfileUserRepository profileUserRepo;
  public ProfileUserService(ProfileUserRepository profileUserRepo){
    this.profileUserRepo = profileUserRepo;
  }
  public ProfileUserDao create(String sessionId, ProfileUserDao profileUserEntity) throws ProfileAlreadyExistsException {
    Long userId = profileUserRepo.create(profileUserEntity);
    profileUserEntity.setUserId(userId);
    return profileUserEntity;
  }

  public String loginUser(String accessToken, String userName, String password){
    return "";
  }
}
