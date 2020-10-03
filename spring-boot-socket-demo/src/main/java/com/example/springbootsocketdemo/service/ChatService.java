package com.example.springbootsocketdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ChatService {

    @PostMapping("/")
    public String sendMessage(String msg){
        return msg;
    }
}
