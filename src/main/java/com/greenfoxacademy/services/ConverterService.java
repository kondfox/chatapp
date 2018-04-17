package com.greenfoxacademy.services;

import com.greenfoxacademy.models.dto.ChatDTO;
import com.greenfoxacademy.models.entities.ChatEntity;
import org.springframework.stereotype.Service;

@Service
public interface ConverterService {

  ChatEntity dtoToEntity(ChatDTO dto);
  ChatDTO entityToDto(ChatEntity entity);

}
