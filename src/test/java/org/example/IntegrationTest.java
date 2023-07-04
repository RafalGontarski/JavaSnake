package org.example;

import org.example.logic.GameLogic;
import org.example.model.Apple;
import org.example.model.Snake;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void testSnakeEatsApple() {
        GameFrame gameFrame = new GameFrame();
        GameLogic gameLogic = gameFrame.getGameLogic();
        Snake snake = gameLogic.getSnake();
        Apple apple = gameLogic.getApple();

        // Initially, the snake has 3 segments
        Assert.assertEquals(3, snake.getBody().size());

        // We move the snake to the position of the apple
        snake.getHead().setLocation(apple.getPosition());

        // We invoke the logic of the game
        gameFrame.getTimer().getActionListeners()[0].actionPerformed(null);

        // The hose should now be longer
        Assert.assertEquals(4, snake.getBody().size());

        // Your score should increase
        Assert.assertEquals(10, gameLogic.getScore());

        // The position of the apple should change
        Assert.assertNotEquals(apple.getPosition(), snake.getHead());
    }
}

