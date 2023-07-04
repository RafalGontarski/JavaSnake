package org.example.model;

import org.example.logic.GameLogic;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class AppleTest {

    @Test
    public void testNewPosition() {
        int width = GameLogic.WIDTH;
        int height = GameLogic.HEIGHT;
        int size = GameLogic.SIZE;
        Apple apple = new Apple(width, height, size);

        // We will save the old position of the apple
        Point oldPosition = new Point(apple.getPosition());

        // We create a new apple position
        apple.newPosition();

        // The new position of the apple should not be the same as the old one
        Assert.assertNotEquals(oldPosition, apple.getPosition());

        // The new position of the apple should be within the bounds of the game board
        Assert.assertTrue(apple.getPosition().x >= 0);
        Assert.assertTrue(apple.getPosition().x < GameLogic.WIDTH);
        Assert.assertTrue(apple.getPosition().y >= 0);
        Assert.assertTrue(apple.getPosition().y < GameLogic.HEIGHT);
    }
}
