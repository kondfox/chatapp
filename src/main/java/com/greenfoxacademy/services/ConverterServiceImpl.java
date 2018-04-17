package com.greenfoxacademy.services;

import com.greenfoxacademy.configurations.Configs;
import com.greenfoxacademy.models.dto.ChatDTO;
import com.greenfoxacademy.models.dto.ChatMessageDTO;
import com.greenfoxacademy.models.dto.ClientDTO;
import com.greenfoxacademy.models.entities.ChatEntity;
import com.greenfoxacademy.models.entities.ChatMessage;
import com.greenfoxacademy.models.entities.ChatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService {

  @Autowired
  UserService userService;

  @Override
  public ChatEntity dtoToEntity(ChatDTO dto) {
    if (dto instanceof ChatMessageDTO) {
      return chatMessageDtoToEntity((ChatMessageDTO) dto);
    } else if (dto instanceof ClientDTO) {
      return chatClientDtoToEntity((ClientDTO) dto);
    }
    return null;
  }

  private ChatUser chatClientDtoToEntity(ClientDTO dto) {
    ChatUser user = userService.getUserByName(dto.getId());
    return user;
  }

  private ChatMessage chatMessageDtoToEntity(ChatMessageDTO dto) {
    ChatMessage message = Configs.chatAppFactory.getBean(ChatMessage.class);
    message.setId(dto.getId());
    message.setOwner(userService.getUserByName(dto.getUserName()));
    message.setText(dto.getText());
    message.setTimestamp(dto.getTimestamp());
    return message;
  }

  @Override
  public ChatDTO entityToDto(ChatEntity entity) {
    if (entity instanceof ChatMessage) {
      return chatMessageEntityToDTO((ChatMessage) entity);
    } else if (entity instanceof ChatUser) {
      return chatUserEntityToDTO((ChatUser) entity);
    }
    return null;
  }

  private ClientDTO chatUserEntityToDTO(ChatUser entity) {
    ClientDTO dto = Configs.chatAppFactory.getBean(ClientDTO.class);
    dto.setId(entity.getName());
    return dto;
  }

  private ChatMessageDTO chatMessageEntityToDTO(ChatMessage entity) {
    ChatMessageDTO dto = Configs.chatAppFactory.getBean(ChatMessageDTO.class);
    dto.setId(entity.getId());
    dto.setUserName(entity.getOwner().getName());
    dto.setText(entity.getText());
    dto.setTimestamp(entity.getTimestamp());
    return dto;
  }


}
