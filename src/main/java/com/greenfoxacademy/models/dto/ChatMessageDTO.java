package com.greenfoxacademy.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatMessageDTO implements ChatDTO {

  private Long id;
  @JsonProperty("username")
  private String userName;
  private String text;
  private Long timestamp;

  public ChatMessageDTO() {
  }

  public ChatMessageDTO(Long id, String userName, String text, Long timestamp) {
    this.id = id;
    this.userName = userName;
    this.text = text;
    this.timestamp = timestamp;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
}
