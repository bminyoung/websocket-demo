package com.example.springbootsocketdemo.controller;

import com.example.springbootsocketdemo.service.ChatService;
import com.example.springbootsocketdemo.vo.SocketVO;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@RestController
//@RequestMapping("/chats")
public class ChatController {

    //메시지 받기
    @MessageMapping("/sendMsg")
    //메시지 반환
    @SendTo("/public")
    public SocketVO sendMessage(SocketVO socketVO){
        long userId = socketVO.getUserId();
        String content = socketVO.getContent();

        SocketVO res = new SocketVO(userId, content);
        return res;
    }
}
