package com.greenfoxacademy.services;

import com.greenfoxacademy.models.dto.RestChatMessageDTO;
import com.greenfoxacademy.models.entities.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService {

  void saveMessage(ChatMessage message);
  void saveMessage(RestChatMessageDTO message);
  List<ChatMessage> getAllMessages();
}
