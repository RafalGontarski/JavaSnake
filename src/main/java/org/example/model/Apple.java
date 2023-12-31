package org.example.model;

import java.awt.*;
import java.util.Random;

public class Apple {
    private Point position;
    private final int width;
    private final int height;
    private final int size;
    private Random random = new Random();

    public Apple(int width, int height, int size) {
        this.width = width;
        this.height = height;
        this.size = size;
        position = new Point(0, 0);
        newPosition();
    }

    public Point getPosition() {
        return position;
    }

    public void newPosition() {
        int r = random.nextInt(width / size);
        position.x = ((r * size));

        r = random.nextInt(height / size);
        position.y = ((r * size));
    }
}
