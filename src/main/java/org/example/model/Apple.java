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
    }

    public Point getPosition() {
        return position;
    }
}
