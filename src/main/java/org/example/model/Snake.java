package org.example.model;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Point direction;

    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(50,50));
        body.add(new Point(40,50));
        body.add(new Point(30,50));
        direction = new Point(0, 0);
    }

    public void setDirection(Point direction) {
        this.direction = direction;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return body.getFirst();
    }
}
