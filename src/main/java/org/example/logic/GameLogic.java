package org.example.logic;

import org.example.model.Apple;
import org.example.model.Snake;

import java.awt.*;

public class GameLogic {
    public static final int SIZE = 10;
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    private Snake snake;
    private Apple apple;
    private static int score;
    private boolean inGame = true;

    public GameLogic() {
        snake = new Snake();
        apple = new Apple(WIDTH, HEIGHT, SIZE);
        score = 0;
    }

    public void checkApple() {
        if (snake.getHead().equals(apple.getPosition())) {
            snake.grow();
            apple.newPosition();
            score += 10;
        }
    }

    public void checkCollision() {
        if (snake.collidesWithItself()) {
            inGame = false;
        }
    }

    private boolean isWithinBounds(Point p) {
        return p.x >= 0 && p.x < WIDTH && p.y >= 0 && p.y < HEIGHT;
    }

    public void move() {
        snake.move();
    }

    public void resetGame() {
        snake = new Snake();
        apple.newPosition();
        score = 0;
        inGame = true;
    }


    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    public boolean isInGame() {
        return inGame;
    }

    public static int getScore() {
        return score;
    }
}
