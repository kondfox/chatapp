package com.greenfoxacademy.controllers.web;

import com.greenfoxacademy.models.entities.ChatMessage;
import com.greenfoxacademy.models.entities.ChatUser;
import com.greenfoxacademy.services.ChatService;
import com.greenfoxacademy.services.LogService;
import com.greenfoxacademy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {

  @Autowired
  LogService logService;
  @Autowired
  UserService userService;
  @Autowired
  ChatService chatService;

  @GetMapping("/")
  public String showMainPage(Model model) {
    logService.infoLog("/", "GET");
    ChatUser user = userService.getUser(1);
    List<ChatMessage> messages = chatService.getAllMessages();
    model.addAttribute("messages", messages);
    model.addAttribute("newMessage", new ChatMessage());
    if (user == null) {
      model.addAttribute("chatUser", new ChatUser());
      return "redirect:/enter";
    }
    model.addAttribute("chatUser", user);
    return "index";
  }

  @GetMapping("/enter")
  public String showEnterPage(Model model) {
    logService.infoLog("/enter", "GET");
    ChatUser user = userService.getUser(1);
    if (user != null) {
      return "redirect:/";
    }
    model.addAttribute("chatUser", new ChatUser());
    return "enter";
  }

  @PostMapping("/enter")
  public String enter(@ModelAttribute ChatUser user) {
    logService.infoLog("/enter", "POST", user.toString());
    userService.save(user);
    return "redirect:/";
  }

  @PostMapping("/update")
  public String update(@ModelAttribute ChatUser user) {
    logService.infoLog("/enter", "update", user.toString());
    userService.modify(user);
    return "redirect:/";
  }

}
