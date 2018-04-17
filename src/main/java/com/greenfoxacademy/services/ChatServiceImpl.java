package com.greenfoxacademy.services;

import com.greenfoxacademy.models.dto.ChatMessageDTO;
import com.greenfoxacademy.models.dto.RestChatMessageDTO;
import com.greenfoxacademy.models.entities.ChatMessage;
import com.greenfoxacademy.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

  @Autowired
  ChatRepository chatRepository;
  @Autowired
  ConverterService converterService;

  @Override
  public void saveMessage(ChatMessage message) {
    chatRepository.save(message);
  }

  @Override
  public void saveMessage(RestChatMessageDTO message) {
    String sender = message.getClient().getId();
    ChatMessageDTO messageDTO = message.getMessage();

    if (sender == null || sender.equals(messageDTO.getUserName())) {
      return;
    }

    ChatMessage chatMessage = (ChatMessage) converterService.dtoToEntity(messageDTO);
    chatRepository.save(chatMessage);

  }

  @Override
  public List<ChatMessage> getAllMessages() {
    List<ChatMessage> messages = chatRepository.findAll();
    sortMessages(messages);
    return messages;
  }

  private void sortMessages(List<ChatMessage> messages) {
    Collections.sort(messages, new Comparator<ChatMessage>() {
      @Override
      public int compare(ChatMessage o1, ChatMessage o2) {
        return o1.getTimestamp() > o2.getTimestamp() ? -1 : 1;
      }
    });
  }
}
