package org.example.logic;

import org.junit.Assert;
import org.junit.Test;

public class GameLogicTest {

    @Test
    public void testCheckApple() {
        GameLogic gameLogic = new GameLogic();

        // Initially, the game is on, so the snake can eat the apple
        gameLogic.getSnake().getHead().setLocation(gameLogic.getApple().getPosition());
        gameLogic.checkApple();

        // The hose should now be longer
        Assert.assertEquals(4, gameLogic.getSnake().getBody().size());

        // Your score should increase
        Assert.assertEquals(10, gameLogic.getScore());
    }

    @Test
    public void testCheckCollision() {
        GameLogic gameLogic = new GameLogic();

        // Self-collision simulation
        gameLogic.getSnake().getBody().addFirst(gameLogic.getSnake().getHead());
        gameLogic.checkCollision();

        // The game should end
        Assert.assertFalse(gameLogic.isInGame());
    }
}
