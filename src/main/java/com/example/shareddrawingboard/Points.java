package com.example.shareddrawingboard;

import java.util.List;

public class Points {

    String chatRoomId;
    List<Point> points;

    public Points(String chatRoomId, List<Point> points) {
        this.chatRoomId = chatRoomId;
        this.points = points;
    }

    public Points() {

    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Points{" +
                "chatRoomId='" + chatRoomId + '\'' +
                ", points=" + points +
                '}';
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
