package com.greenfoxacademy.models.dto;

public class StatusDTO implements ChatDTO {

  private String status;

  public StatusDTO() {
  }

  public StatusDTO(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
