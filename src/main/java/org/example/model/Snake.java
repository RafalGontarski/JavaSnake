package org.example.model;

import org.example.logic.GameLogic;

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
        direction = new Point(10, 0);
    }

    public void setDirection(Point direction) {
        this.direction = direction;
    }

    public void grow() {
        // Add a new point in the same location as the last segment
        body.addLast(new Point(body.getLast()));
    }

    public void move() {
        // Move the snake by adding a new head and removing the last segment
        int x = (body.getFirst().x + direction.x);
        int y = (body.getFirst().y + direction.y);
        if (x >= GameLogic.WIDTH) {
            x = 0;
        } else if (x < 0) {
            x = GameLogic.WIDTH - GameLogic.SIZE;
        }
        if (y >= GameLogic.HEIGHT) {
            y = 0;
        } else if (y < 0) {
            y = GameLogic.HEIGHT - GameLogic.SIZE;
        }

        body.addFirst(new Point(x, y));
        body.removeLast();
    }

    public boolean collidesWithItself() {
        for (int i = 1; i < body.size(); i++) {
            if (getHead().equals(body.get(i))) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return body.getFirst();
    }
}
