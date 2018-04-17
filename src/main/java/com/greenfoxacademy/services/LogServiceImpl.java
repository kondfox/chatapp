package com.greenfoxacademy.services;

import com.greenfoxacademy.models.logs.ErrorLog;
import com.greenfoxacademy.models.logs.InfoLog;
import com.greenfoxacademy.models.logs.LogMessage;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

  private String logLevel;

  public LogServiceImpl() {
    logLevel = System.getenv().get("CHAT_APP_LOGLEVEL");
  }

  @Override
  public void errorLog(String path, String method) {
    errorLog(path, method, "");
  }

  @Override
  public void errorLog(String path, String method, String params) {
    LogMessage logMessage = new ErrorLog(path, method, params);
    printLog(logMessage);
  }

  @Override
  public void infoLog(String path, String method) {
    infoLog(path, method, "");
  }

  @Override
  public void infoLog(String path, String method, String params) {
    LogMessage logMessage = new InfoLog(path, method, params);
    printLog(logMessage);
  }

  @Override
  public void printLog(LogMessage logMessage) {
    if (shouldPrint(logMessage)) {
      if (logMessage instanceof InfoLog) {
        System.out.println(logMessage);
      } else if (logMessage instanceof ErrorLog) {
        System.err.println(logMessage);
      }
    }
  }

  private boolean shouldPrint(LogMessage logMessage) {
    boolean shouldPrint = true;
    if (logLevel.equals(ErrorLog.level) && logMessage instanceof InfoLog) {
      shouldPrint = false;
    }
    return shouldPrint;
  }
}
