package com.poc.chat_backend.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    public ChatController(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // Gère l'envoi de messages de chat
    @MessageMapping("/chat.sendMessage") // Les messages envoyés à /app/chat.sendMessage seront traités ici
    public void sendMessage(@Payload ChatMessage chatMessage) {
        chatMessage.setTimestamp(LocalDateTime.now());
        // Envoie le message à tous les abonnés du topic /topic/public
        // ou à un topic spécifique si on veut un chat par conversation
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
        // Pour un chat client-agent, on pourrait avoir :
        // if (chatMessage.getRecipientType().equals("AGENT")) {
        //    messagingTemplate.convertAndSendToUser(chatMessage.getRecipientId(), "/queue/messages", chatMessage);
        // } else {
        //    messagingTemplate.convertAndSendToUser(chatMessage.getSenderId(), "/queue/messages", chatMessage);
        // }
    }

    // Gère l'ajout d'un nouvel utilisateur au chat (pour des messages de statut)
    @MessageMapping("/chat.addUser") // Les messages envoyés à /app/chat.addUser seront traités ici
    public void addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Ajoute l'username dans les attributs de session WebSocket
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        chatMessage.setTimestamp(LocalDateTime.now());
        // Informe tous les abonnés qu'un nouvel utilisateur a rejoint
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
    }
}



