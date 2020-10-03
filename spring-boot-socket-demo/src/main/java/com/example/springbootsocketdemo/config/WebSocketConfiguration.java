package com.example.springbootsocketdemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    //endpoint 등록
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }

    //메시지 브로커 옵션
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //controller의 @MessageMapping으로 라우팅한다
        registry.setApplicationDestinationPrefixes("/pub");
        //경로를 구독하는 client에게 메시지를 전달한다
        registry.enableSimpleBroker("/topic");
    }
}
