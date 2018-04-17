package com.greenfoxacademy.models.dto;

public class ClientDTO implements ChatDTO {

  private String id;

  public ClientDTO() {
  }

  public ClientDTO(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
