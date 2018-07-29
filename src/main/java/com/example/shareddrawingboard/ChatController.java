package com.example.shareddrawingboard;


import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class ChatController {

    @RequestMapping("/shared-board")
    public String sharedBoard() {
        return "board";
    }

    @MessageMapping("/points/{url}")
    @SendTo("/topic/points.{url}")
    public Points getPoint(@DestinationVariable String url,  Points points) {
        System.out.println(url);
        return points;
    }



}