package com.example.shareddrawingboard;

public class Point {

    private  int prevX;
    private  int prevY;
    private  int x;
    private  int y;


    public Point(int prevX, int prevY, int x, int y) {
        this.prevX = prevX;
        this.prevY = prevY;
        this.x = x;
        this.y = y;
    }


    public Point() {
    }

    public int getPrevX() {
        return prevX;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void setY(int y) {
        this.y = y;
    }

}
