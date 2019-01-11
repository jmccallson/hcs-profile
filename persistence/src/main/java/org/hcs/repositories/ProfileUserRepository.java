package org.hcs.repositories;

import org.hcs.data.ProfileUserDao;
import org.hcs.exceptions.ProfileAlreadyExistsException;
import org.hcs.exceptions.ProfileInternalException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProfileUserRepository {
  private final JdbcTemplate jdbcTemplate;

  public ProfileUserRepository(JdbcTemplate jdbcTemplate){
    this.jdbcTemplate = jdbcTemplate;
  }

  public Long create(ProfileUserDao profileUserDao) throws ProfileAlreadyExistsException {
    Long userId;
    String sql = "insert into profile_user ( " +
      "user_id, " +
      "login_name, " +
      "login_name_lc, " +
      "first_name, " +
      "first_name_lc, " +
      "last_name, " +
      "last_name_lc, " +
      "job_title, " +
      "account_type, " +
      "create_date," +
      "update_date, " +
      "enabled, " +
      "user_type_id, " +
      "visibility, " +
      "on_call) values(?,?,Lower(?),?,Lower(?),?,Lower(?),?,?,?,?,?,?,?,?)";

    userId = jdbcTemplate.queryForObject("select nextval('SEQ_PROFILE_USER')", Long.class);
    try {
      jdbcTemplate.update(
        sql,
        userId,
        profileUserDao.getLoginName(),
        profileUserDao.getLoginName(),
        profileUserDao.getFirstName(),
        profileUserDao.getFirstName(),
        profileUserDao.getLastName(),
        profileUserDao.getLastName(),
        profileUserDao.getJobTitle(),
        profileUserDao.getAccountType(),
        profileUserDao.getCreateDate(),
        profileUserDao.getUpdateDate(),
        profileUserDao.getEnabled(),
        profileUserDao.getUserTypeId(),
        profileUserDao.getVisibility(),
        profileUserDao.getOnCall()
      );
    }
    catch (DataIntegrityViolationException e) {
      if (e.getMessage().contains("login_name_lc")) {
        throw new ProfileAlreadyExistsException("Login Name already exists", e);
      }
      else if (e.getMessage().contains("user_type_id")) {
        throw new ProfileAlreadyExistsException("User Type Id already exists", e);
      }
      else {
        throw new ProfileAlreadyExistsException("Error ", e);
      }
    }
    catch(DataAccessException e) {
      throw new ProfileInternalException("Insert error for profile user ", e);
    }
    return userId;
  }

  static final class ProfileUserMapper implements RowMapper<ProfileUserDao>{
    @Override
    public ProfileUserDao mapRow(ResultSet resultSet, int i) throws SQLException {
      ProfileUserDao profileUserEntity = new ProfileUserDao();
      profileUserEntity.setUserId(resultSet.getLong("USER_ID"));
      profileUserEntity.setLoginName(resultSet.getString("LOGIN_NAME"));
      profileUserEntity.setLoginNameLc(resultSet.getString("LOGIN_NAME_LC"));
      profileUserEntity.setFirstName(resultSet.getString("FIRST_NAME"));
      profileUserEntity.setFirstNameLc(resultSet.getString("FIRST_NAME_LC"));
      profileUserEntity.setLastName(resultSet.getString("LAST_NAME"));
      profileUserEntity.setLastNameLc(resultSet.getString("LAST_NAME_LC"));
      profileUserEntity.setJobTitle(resultSet.getString("JOB_TITLE"));
      profileUserEntity.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
      profileUserEntity.setCreateDate(resultSet.getTimestamp("CREATE_DATE"));
      profileUserEntity.setUpdateDate(resultSet.getTimestamp("UPDATE_DATE"));
      profileUserEntity.setEnabled(resultSet.getString("ENABLED"));
      profileUserEntity.setUserTypeId(resultSet.getLong("USER_TYPE_ID"));
      profileUserEntity.setVisibility(resultSet.getString("VISIBILITY"));
      profileUserEntity.setOnCall(resultSet.getString("ON_CALL"));
      return profileUserEntity;
    }
  }
}


