package org.hcs.ws.v1.controllers;

import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import net.logstash.logback.marker.LogstashMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hcs.ProfileUserService;
import org.hcs.data.ProfileUserDao;
import org.hcs.exceptions.*;
import org.hcs.ws.v1.utils.ProfileUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;

import static net.logstash.logback.marker.Markers.append;
import static org.hcs.ws.v1.ExceptionHandler.USER_AGENT;
import static org.hcs.ws.v1.ExceptionHandler.handleExceptions;

@RestController
public class ProfileUserController {
  //private static final String USER_AGENT = "User-Agent";
  private static final String USER_AGENT_CHAIN = "User-Agent-Chain";
  private static final Logger LOG = LoggerFactory.getLogger(ProfileUserController.class);
  private static final String NO_SESSION_ELEMENT_FOUND = "No session element found";
  private final ProfileUserService profileUserService;

  public ProfileUserController(ProfileUserService profileUserService){
    this.profileUserService = profileUserService;
  }

  /**
   * @param authHeader "Authorization Bearer {sessionId}" as defined in rfc6750
   */
  @StatusCodes({
    @ResponseCode(code = HttpURLConnection.HTTP_OK, condition = ProfileUtil.OK_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_BAD_REQUEST, condition = ProfileUtil.INVALID_RQST_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_UNAUTHORIZED, condition = ProfileUtil.UNAUTHORIZED_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_NOT_FOUND, condition = ProfileUtil.USER_NOT_FOUND_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_INTERNAL_ERROR, condition = ProfileUtil.INTERNAL_ERR_CONDITION_MSG)
  })
  @RequestMapping(value = "/userprofile",  method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<Object> createUserProfile(@RequestHeader("Authorization") String authHeader, //NOSONAR
                                                  @RequestBody ProfileUserDao profileUserEntity,
                                                  WebRequest request)
    throws ProfileExpiredSessionException, ProfileInvalidRequestException, ProfileAlreadyExistsException {
    String sessionId = ProfileUtil.getBearerToken(authHeader);
    if(sessionId == null || sessionId.isEmpty()){
      throw new ProfileExpiredSessionException(NO_SESSION_ELEMENT_FOUND, new Throwable(ProfileUtil.UNAUTHORIZED_CONDITION_MSG));
    }

    if(null == profileUserEntity){
      throw new ProfileInvalidRequestException("Request body is null", new Throwable(ProfileUtil.INVALID_RQST_CONDITION_MSG));
    }
    ProfileUserDao newProfileUserData = profileUserService.create(sessionId, profileUserEntity);

    String userAgent = request.getHeader(USER_AGENT);
    String userAgentChain = request.getHeader(USER_AGENT_CHAIN);
    LogstashMarker markers = getLogMarkers(userAgent, userAgentChain);
    LOG.info(markers, "User-Profile /userprofile endpoint success with Payload {}.", ProfileUtil.profileUserDataToJson(profileUserEntity));
    return new ResponseEntity<>(newProfileUserData, HttpStatus.OK);
  }

  @RequestMapping(value = "/userprofile/{userId}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void getUserProfile(@RequestHeader("Authorization") String authHeader, //NOSONAR
                             @PathVariable String userId,
                             WebRequest request)
    throws ProfileExpiredSessionException
  {
    String sessionId = ProfileUtil.getBearerToken(authHeader);
    if (sessionId == null || sessionId.isEmpty()) {
      throw new ProfileExpiredSessionException(NO_SESSION_ELEMENT_FOUND, new Throwable(ProfileUtil.UNAUTHORIZED_CONDITION_MSG));
    }
  }

  @StatusCodes({
    @ResponseCode(code = HttpURLConnection.HTTP_OK, condition = ProfileUtil.OK_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_BAD_REQUEST, condition = ProfileUtil.INVALID_RQST_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_UNAUTHORIZED, condition = ProfileUtil.UNAUTHORIZED_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_NOT_FOUND, condition = ProfileUtil.USER_NOT_FOUND_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_INTERNAL_ERROR, condition = ProfileUtil.INTERNAL_ERR_CONDITION_MSG)
  })

  @RequestMapping(value = "/userprofile/{userId}",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public void updateUserProfile(@RequestHeader("Authorization") String authHeader, //NOSONAR
                                @PathVariable String userId,
                                @RequestBody ProfileUserDao profileUserDAO,
                                WebRequest request)
    throws ProfileExpiredSessionException
  {
    String sessionId = ProfileUtil.getBearerToken(authHeader);
    if (sessionId == null || sessionId.isEmpty()) {
      throw new ProfileExpiredSessionException(NO_SESSION_ELEMENT_FOUND, new Throwable(ProfileUtil.UNAUTHORIZED_CONDITION_MSG));
    }
  }

  /**
   * @param authHeader "Authorization Bearer {sessionId}" as defined in rfc6750
   */
  @StatusCodes({
    @ResponseCode(code = HttpURLConnection.HTTP_OK, condition = ProfileUtil.OK_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_BAD_REQUEST, condition = ProfileUtil.INVALID_RQST_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_UNAUTHORIZED, condition = ProfileUtil.UNAUTHORIZED_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_NOT_FOUND, condition = ProfileUtil.USER_NOT_FOUND_CONDITION_MSG),
    @ResponseCode(code = HttpURLConnection.HTTP_INTERNAL_ERROR, condition = ProfileUtil.INTERNAL_ERR_CONDITION_MSG)
  })

  @RequestMapping(value = "/userprofile/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
  public void deleteUserProfile(@RequestHeader("Authorization") String authHeader, //NOSONAR
                                @PathVariable("userId") String userId,
                                WebRequest request) throws ProfileExpiredSessionException {

    String sessionId = ProfileUtil.getBearerToken(authHeader);
    if (sessionId == null || sessionId.isEmpty()) {
      throw new ProfileExpiredSessionException(NO_SESSION_ELEMENT_FOUND, new Throwable(ProfileUtil.UNAUTHORIZED_CONDITION_MSG));
    }
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE} , consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<String> login(@RequestHeader("Authorization") String authHeader, //NOSONAR
                                            @RequestBody String body,
                                            WebRequest request)
    throws ProfileUnauthorizedException, ProfileInvalidRequestException,ProfileExpiredSessionException,
    ProfileNotFoundException {
    String accessToken = ProfileUtil.getBearerToken(authHeader);
    if (accessToken == null) {
      throw new ProfileUnauthorizedException("No bearer token provided.  Caller is unauthorized.");
    }

    String userName = "";
    String password = "";
    String userAgent = request.getHeader(USER_AGENT);
    String userAgentChain = request.getHeader(USER_AGENT_CHAIN);
    LogstashMarker markers = getLogMarkers(userAgent, userAgentChain);
    LOG.info(markers, "HCS-Security /userinfo (GET) endpoint success.");
    String result = profileUserService.loginUser(accessToken, userName, password);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @ExceptionHandler(value = {
    ProfileExpiredSessionException.class,
    ProfileInternalException.class,
    ProfileUnauthorizedException.class,
    ProfileInvalidRequestException.class,
    ProfileNotFoundException.class,
    ProfileAlreadyExistsException.class,
    RuntimeException.class})
  @ResponseBody
  private ResponseEntity<String> handleExceptionsWithHttpResponse(Exception exception, HttpServletRequest request, HttpServletResponse response ) {
    return handleExceptions(exception, request, response);
  }

  private LogstashMarker getLogMarkers(String userAgent, String userAgentChain) {
    LogstashMarker markers = append(USER_AGENT, userAgent);
    markers.add(append(USER_AGENT_CHAIN, userAgentChain));
    return markers;
  }
}
