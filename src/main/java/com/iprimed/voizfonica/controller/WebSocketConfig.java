package com.iprimed.voizfonica.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements  WebSocketMessageBrokerConfigurer{

@Override
public  void configureMessageBroker(MessageBrokerRegistry config)
{
    System.out.println("web socket configurer");
    config.enableSimpleBroker("/lesson");
    config.setApplicationDestinationPrefixes("/app");

}
@Override
public void registerStompEndpoints(StompEndpointRegistry registry)
{
    System.out.println("stomp end point   config method");
    registry.addEndpoint("/gs-guide-websocket").withSockJS();
}
}
