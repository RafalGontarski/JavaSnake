package org.example;

import org.junit.Assert;
import org.junit.Test;

public class GameFrameTest {

    @Test
    public void testInitGame() {
        GameFrame gameFrame = new GameFrame();

        // The game should be initialized
        Assert.assertNotNull(gameFrame.getGameLogic());

        // The timer should be running
        Assert.assertTrue(gameFrame.getTimer().isRunning());

        // The game should be active
        Assert.assertTrue(gameFrame.getGameLogic().isInGame());
    }
}
