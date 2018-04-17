package com.greenfoxacademy.configurations;

import com.greenfoxacademy.models.dto.ChatMessageDTO;
import com.greenfoxacademy.models.dto.ClientDTO;
import com.greenfoxacademy.models.dto.StatusDTO;
import com.greenfoxacademy.models.entities.ChatMessage;
import com.greenfoxacademy.models.entities.ChatUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ChatAppConfiguration {

  @Bean
  @Scope("prototype")
  public ChatMessage getChatMessage() {
    return new ChatMessage();
  }

  @Bean
  @Scope("prototype")
  public ChatMessageDTO getChatMessageDTO() {
    return new ChatMessageDTO();
  }

  @Bean
  @Scope("prototype")
  public ChatUser getChatUser() {
    return new ChatUser();
  }

  @Bean
  @Scope("prototype")
  public ClientDTO getClientDTO() {
    return new ClientDTO();
  }

  @Bean(name = "okMessage")
  @Scope("prototype")
  public StatusDTO getOkMessage() {
    return new StatusDTO("ok");
  }

}
