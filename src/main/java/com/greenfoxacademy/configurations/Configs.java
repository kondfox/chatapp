package com.greenfoxacademy.configurations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Configs {

  public static final ApplicationContext chatAppFactory;
  static {
    chatAppFactory = new AnnotationConfigApplicationContext(ChatAppConfiguration.class);
  }

}
