package com.greenfoxacademy.repositories;

import com.greenfoxacademy.models.entities.ChatUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser, Long> {

  ChatUser findOneByName(String name);

}
