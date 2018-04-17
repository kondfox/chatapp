package com.greenfoxacademy.models.dto;

public class RestChatMessageDTO implements ChatDTO {

  private ChatMessageDTO message;
  private ClientDTO client;

  public RestChatMessageDTO() {
  }

  public ChatMessageDTO getMessage() {
    return message;
  }

  public void setMessage(ChatMessageDTO message) {
    this.message = message;
  }

  public ClientDTO getClient() {
    return client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }
}
