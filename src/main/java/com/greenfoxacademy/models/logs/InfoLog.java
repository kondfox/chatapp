package com.greenfoxacademy.models.logs;

public class InfoLog extends LogMessage {

  public static final String level = "INFO";

  public InfoLog() {
    setLevel(level);
  }

  public InfoLog(String path, String method, String params) {
    super(level, path, method, params);
  }
}
