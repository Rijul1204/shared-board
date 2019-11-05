package com.example.shareddrawingboard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;


@Controller
public class BoardController {

    public static final String TOPIC_POINTS = "/topic/points";
    @Autowired
    private SimpMessagingTemplate webSocketMessagingTemplate;

    public static Map<String, String> userMap = new HashMap<>();

    @RequestMapping("/shared-board")
    public String sharedBoard() {
        return "board";
    }

    @MessageMapping("/points")
    public Points getPoint(Points points){
        webSocketMessagingTemplate.convertAndSend("/topic/" + points.chatRoomId + ".public.messages",
                points);

        return points;
    }
}