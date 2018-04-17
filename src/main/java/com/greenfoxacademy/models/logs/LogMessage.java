package com.greenfoxacademy.models.logs;

import java.time.LocalDateTime;

public abstract class LogMessage {

  private String path;
  private String method;
  private LocalDateTime time;
  private String level;
  private String params;

  public LogMessage() {
    time = LocalDateTime.now();
  }

  public LogMessage(String level, String path, String method, String params) {
    time = LocalDateTime.now();
    this.path = path;
    this.method = method;
    this.level = level;
    this.params = params;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getParams() {
    return params;
  }

  public void setParams(String params) {
    this.params = params;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder
            .append(time.toString())
            .append(" ")
            .append(level)
            .append(" Request ")
            .append(path)
            .append(" ")
            .append(method)
            .append(" ")
            .append(params);
    return stringBuilder.toString();
  }
}
