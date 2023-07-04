package org.example.model;

import org.example.logic.GameLogic;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class SnakeTest {

    @Test
    public void testMove() {
        Snake snake = new Snake();
        Point oldHeadPosition = new Point(snake.getHead());
        Point direction = new Point(0, GameLogic.SIZE);

        // We set a new direction for the snake and make a move
        snake.setDirection(direction);
        snake.move();

        // The head should move in a new direction
        Assert.assertEquals(oldHeadPosition.x + direction.x, snake.getHead().x);
        Assert.assertEquals(oldHeadPosition.y + direction.y, snake.getHead().y);

        // The snake should lose the last body segment (unless it ate the apple)
        Assert.assertEquals(3, snake.getBody().size());
    }

    @Test
    public void testGrow() {
        Snake snake = new Snake();
        int oldSize = snake.getBody().size();

        // We enlarge the snake
        snake.grow();

        // The hose should have one more segment
        Assert.assertEquals(oldSize + 1, snake.getBody().size());
    }

    @Test
    public void testCollidesWithItself() {
        Snake snake = new Snake();

        // We simulate a collision with ourselves
        snake.getBody().addFirst(snake.getHead());

        // The hose should collide with itself
        Assert.assertTrue(snake.collidesWithItself());
    }
}
