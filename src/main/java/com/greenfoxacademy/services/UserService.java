package com.greenfoxacademy.services;

import com.greenfoxacademy.models.entities.ChatMessage;
import com.greenfoxacademy.models.entities.ChatUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  boolean save(ChatUser user);
  ChatUser getUser(long id);
  ChatUser getUserByName(String name);
  void modify(ChatUser user);
  void saveMessage(ChatUser user, ChatMessage message);

}
