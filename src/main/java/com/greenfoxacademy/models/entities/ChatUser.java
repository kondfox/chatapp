package com.greenfoxacademy.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ChatUser implements ChatEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @JsonIgnore
  @OneToMany(mappedBy = "owner")
  List<ChatMessage> messages;

  public ChatUser() {
    messages = new ArrayList<>();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addMessage(ChatMessage message) {
    messages.add(message);
    message.setOwner(this);
  }

  @Override
  public String toString() {
    return "ChatUser{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
