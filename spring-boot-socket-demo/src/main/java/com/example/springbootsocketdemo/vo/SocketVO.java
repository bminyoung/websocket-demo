package com.example.springbootsocketdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SocketVO {
    private Long userId;
    private String content;
}
