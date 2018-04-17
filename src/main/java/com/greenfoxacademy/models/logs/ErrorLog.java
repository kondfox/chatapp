package com.greenfoxacademy.models.logs;

public class ErrorLog extends LogMessage {

  public static final String level = "ERROR";

  public ErrorLog() {
    setLevel(level);
  }

  public ErrorLog(String path, String method, String params) {
    super(level, path, method, params);
  }
}
