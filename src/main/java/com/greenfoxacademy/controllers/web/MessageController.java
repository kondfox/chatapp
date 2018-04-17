package com.greenfoxacademy.controllers.web;

import com.greenfoxacademy.models.entities.ChatMessage;
import com.greenfoxacademy.models.entities.ChatUser;
import com.greenfoxacademy.services.LogService;
import com.greenfoxacademy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

  @Autowired
  UserService userService;
  @Autowired
  LogService logService;

  @PostMapping("/message/{userId}")
  public String postMessage(@PathVariable long userId, @ModelAttribute ChatMessage message) {
    logService.infoLog("/message/" + userId, "POST", message.toString());
    ChatUser user = userService.getUser(userId);
    if (user != null) {
      userService.saveMessage(user, message);
    }
    return "redirect:/";
  }

}
