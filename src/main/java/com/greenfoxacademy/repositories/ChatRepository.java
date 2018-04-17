package com.greenfoxacademy.repositories;

import com.greenfoxacademy.models.entities.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends CrudRepository<ChatMessage, Long> {

  List<ChatMessage> findAll();
}
