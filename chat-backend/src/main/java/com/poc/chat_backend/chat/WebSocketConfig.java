package com.poc.chat_backend.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Active un broker de messages en mémoire pour transporter les messages aux clients abonnés
        // Les destinations préfixées par "/topic" seront gérées par le broker
        config.enableSimpleBroker("/topic");
        // Les destinations préfixées par "/app" seront routées vers les méthodes annotées @MessageMapping dans les contrôleurs
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Enregistre l'endpoint "/ws" qui sera utilisé par le client pour se connecter au serveur WebSocket
        // withSockJS() est utile pour les navigateurs ne supportant pas nativement les WebSockets
        registry.addEndpoint("/ws").setAllowedOrigins("http://localhost:4200").withSockJS(); // AllowedOrigins pour le PoC, à restreindre en production
    }
}

