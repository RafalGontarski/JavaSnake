package org.example.logic;

import org.example.model.Apple;
import org.example.model.Snake;

public class GameLogic {
    public static final int SIZE = 10;
    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    private Snake snake;
    private Apple apple;
    private boolean inGame = true;

    public GameLogic() {
        snake = new Snake();
        apple = new Apple(WIDTH, HEIGHT, SIZE);
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

    public void checkApple() {
        if (snake.getHead().equals(apple.getPosition())) {
            snake.grow();
            apple.newPosition();
        }
    }
}
