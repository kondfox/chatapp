package com.greenfoxacademy.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

@Entity
public class ChatMessage implements ChatEntity {

  @Id
  private long id;
  @OneToOne
  @JoinColumn(name = "user_id")
  private ChatUser owner;
  private String text;
  private Long timestamp;

  public ChatMessage() {
    Random random = new Random();
    id = random.nextInt(Integer.MAX_VALUE);
    timestamp = LocalDateTime.now().toEpochSecond(ZoneOffset.ofHours(1));
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ChatUser getOwner() {
    return owner;
  }

  public void setOwner(ChatUser owner) {
    this.owner = owner;
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

  @Override
  public String toString() {
    return "ChatMessage{" +
            "id=" + id +
            ", owner=" + owner +
            ", text='" + text + '\'' +
            ", timestamp=" + timestamp +
            '}';
  }
}
