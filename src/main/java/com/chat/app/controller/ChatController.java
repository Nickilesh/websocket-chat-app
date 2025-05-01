package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.apache.catalina.util.CharsetMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        System.out.println("Received message: " + message.getContent());
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
