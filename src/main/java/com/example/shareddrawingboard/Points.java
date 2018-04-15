package com.example.shareddrawingboard;

import java.util.List;

public class Points {

    List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public Points() {

    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Points{" +
                "points=" + points +
                '}';
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
