package com.rnazarapps.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private WebSocketService webSocketService;

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        webSocketService.sendMessageUpdate(createdMessage);
        return createdMessage;
    }

    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable Long id, @RequestBody Message message) {
        Message updatedMessage = messageService.updateMessage(id, message);
        webSocketService.sendMessageUpdate(updatedMessage);
        return updatedMessage;
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        webSocketService.sendMessageDeletion(id);
    }
}

