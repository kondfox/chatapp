package com.greenfoxacademy.services;

import com.greenfoxacademy.models.entities.ChatMessage;
import com.greenfoxacademy.models.entities.ChatUser;
import com.greenfoxacademy.repositories.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  ChatUserRepository userRepository;
  @Autowired
  ChatService chatService;

  @Override
  public boolean save(ChatUser user) {
    userRepository.save(user);
    return true;
  }

  @Override
  public ChatUser getUser(long id) {
    return userRepository.findOne(id);
  }

  @Override
  public ChatUser getUserByName(String name) {
    return userRepository.findOneByName(name);
  }

  @Override
  public void modify(ChatUser user) {
    userRepository.save(user);
  }

  @Override
  public void saveMessage(ChatUser user, ChatMessage message) {
    user.addMessage(message);
    chatService.saveMessage(message);
  }
}
