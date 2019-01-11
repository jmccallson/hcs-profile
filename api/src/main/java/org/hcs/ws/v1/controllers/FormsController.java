package org.hcs.ws.v1.controllers;

import net.logstash.logback.marker.LogstashMarker;
import org.hcs.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static net.logstash.logback.marker.Markers.append;
import static org.hcs.ws.v1.ExceptionHandler.USER_AGENT;
import static org.hcs.ws.v1.ExceptionHandler.handleExceptions;

@RestController
public class FormsController {
  private static final Logger LOG = LoggerFactory.getLogger(FormsController.class);
  private static final String USER_AGENT_CHAIN = "User-Agent-Chain";
  private static final String NO_SESSION_ELEMENT_FOUND = "No session element found";

  public FormsController () {}

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
