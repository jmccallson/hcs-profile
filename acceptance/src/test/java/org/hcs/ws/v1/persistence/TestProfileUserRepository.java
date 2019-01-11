package org.hcs.ws.v1.persistence;

import org.hcs.data.ProfileUserDao;
import org.hcs.exceptions.ProfileAlreadyExistsException;
import org.hcs.repositories.ProfileUserRepository;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;

public class TestProfileUserRepository {
  private JdbcTemplate jdbc = DataSourceSetup.getJdbcTemplate();
  private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

  private ProfileUserRepository profileUserRepository = new ProfileUserRepository(jdbc);

  @Test
  public void testCreateUser(){
    ProfileUserDao profileUserDao = new ProfileUserDao();
    profileUserDao.setLoginName("ghimo");
    profileUserDao.setFirstName("Jim");
    profileUserDao.setLastName("McCallson");
    profileUserDao.setUserTypeId(1000L);
    profileUserDao.setEnabled("T");

    try {
      Long userId = profileUserRepository.create(profileUserDao);

    } catch (ProfileAlreadyExistsException e) {
      e.printStackTrace();
    }
  }

}
