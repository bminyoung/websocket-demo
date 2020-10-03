package com.example.springbootsocketdemo.controller;

import com.example.springbootsocketdemo.service.ChatService;
import com.example.springbootsocketdemo.vo.SocketVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@RestController
@Slf4j
//@RequestMapping("/chats")
public class ChatController {

    //메시지 받기
    @MessageMapping("/sendMsg")
    //메시지 반환
    @SendTo("/topic/public")
    public SocketVO sendMessage(SocketVO socketVO){
        log.info("receive message from vue.js");
        log.info(socketVO.getContent());

        long userId = socketVO.getUserId();
        String content = socketVO.getContent();

        SocketVO res = new SocketVO(userId, content);
        return res;
    }
}
