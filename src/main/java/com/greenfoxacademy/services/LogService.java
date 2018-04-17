package com.greenfoxacademy.services;

import com.greenfoxacademy.models.logs.LogMessage;
import org.springframework.stereotype.Service;

@Service
public interface LogService {

  void errorLog(String path, String method);
  void errorLog(String path, String method, String params);
  void infoLog(String path, String method);
  void infoLog(String path, String method, String params);
  void printLog(LogMessage logMessage);
}
