package com.greenfoxacademy.controllers.rest;

import com.greenfoxacademy.configurations.Configs;
import com.greenfoxacademy.models.dto.ChatDTO;
import com.greenfoxacademy.models.dto.RestChatMessageDTO;
import com.greenfoxacademy.models.dto.StatusDTO;
import com.greenfoxacademy.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

  @Autowired
  ChatService chatService;

  @PostMapping("/api/message/receive")
  public ResponseEntity<ChatDTO> addMessage(@RequestBody RestChatMessageDTO message) {
    chatService.saveMessage(message);
    return ResponseEntity.ok().body(Configs.chatAppFactory.getBean("okMessage", StatusDTO.class));
  }

}
